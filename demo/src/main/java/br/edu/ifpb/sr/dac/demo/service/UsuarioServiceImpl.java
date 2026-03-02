package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.UsuarioMapper;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<GetUsuariosDTO> findAll() {
        return this.usuarioDao.findAll()
                .stream()
                .map(usuario -> new GetUsuariosDTO(usuario.getId(), usuario.getNome(), usuario.getUsername()))
                .toList();
    }
}
