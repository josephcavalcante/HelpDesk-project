package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final PasswordEncoder passwordEncoder;
    private final UsuarioDao usuarioDao;
    public UsuarioServiceImpl (UsuarioDao usuarioDao, PasswordEncoder passwordEncoder){
        this.usuarioDao = usuarioDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void save(PostUsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuario.setUsername(dto.username());
        this.usuarioDao.save(usuario);
    }

    @Override
    public List<GetUsuariosDTO> findAll() {
        return this.usuarioDao.findAll().stream()
                .map(usuario -> new GetUsuariosDTO(usuario.getId(), usuario.getNome(), usuario.getUsername()))
                .collect(Collectors.toList());
    }
}
