package br.edu.ifpb.sr.dac.demo.service.usuario;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.UsuarioMapper;
import br.edu.ifpb.sr.dac.demo.model.Cargo;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final UsuarioMapper usuarioMapper;
    public UsuarioServiceImpl (UsuarioDao usuarioDao, UsuarioMapper usuarioMapper){
        this.usuarioDao = usuarioDao;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @Transactional
    public void save(PostUsuarioDTO dto) {
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        this.usuarioDao.save(usuario);
    }
    @Override
    @Transactional
    public void saveAdmin(PostUsuarioDTO dto) {
        Usuario registrador = this.usuarioDao.findById(dto.idUsuario()).orElseThrow(() -> new RuntimeException("usuário não encontrado"));
        if (registrador.getCargo() != Cargo.ADMIN){
            throw new RuntimeException("usuário não autorizado, apenas administradores podem criar novos administradores");
        }
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
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
    public List<GetUsuariosDTO> findAllAdmin() {
        return this.usuarioDao.findAllByCargo(Cargo.ADMIN)
                .stream()
                .map(this.usuarioMapper::toDto)
                .toList();
    }

}
