package br.edu.ifpb.sr.dac.demo.service.usuario;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.UsuarioMapper;
import br.edu.ifpb.sr.dac.demo.model.Cargo;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;


    public UsuarioServiceImpl(UsuarioDao usuarioDao, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioDao = usuarioDao;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void save(PostUsuarioDTO dto) {

        if (this.usuarioDao.existsByCpf(dto.cpf())) throw new RuntimeException("CPF já cadastrado");
        if (this.usuarioDao.existsByUsername(dto.username())) throw new RuntimeException("username já cadastrado");
        if(this.usuarioDao.existsById(dto.idUsuario())) throw new RuntimeException("usuário já cadastrado");

        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setCargo(Cargo.USUARIO);
        this.usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void saveAdmin(PostUsuarioDTO dto) {
        if (dto.idUsuario() != null) {
            Usuario registrador = this.usuarioDao.findById(dto.idUsuario())
                    .orElseThrow(() -> new RuntimeException("usuário não encontrado"));
            if (registrador.getCargo() != Cargo.ADMIN) {
                throw new RuntimeException(
                        "usuário não autorizado, apenas administradores podem criar novos administradores");
            }
        }
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setCargo(Cargo.ADMIN);
        this.usuarioDao.save(usuario);
    }

    @Override
    public List<GetUsuariosDTO> findAll() {
        return this.usuarioDao.findAll()
                .stream()
                .map(usuario -> new GetUsuariosDTO(usuario.getId(), usuario.getNome(), usuario.getUsername()))
                .toList();
    }

    @Override
    public Page<GetUsuariosDTO> findAllAdmin(Pageable pageable) {
        return this.usuarioDao.findAllByCargo(Cargo.ADMIN, pageable)
                .map(this.usuarioMapper::toDto);
    }

}
