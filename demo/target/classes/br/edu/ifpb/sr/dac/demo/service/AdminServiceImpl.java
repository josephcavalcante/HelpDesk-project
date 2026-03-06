package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostAdminDTO;
import br.edu.ifpb.sr.dac.demo.dto.UsuarioMapper;
import br.edu.ifpb.sr.dac.demo.model.Cargo;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final UsuarioDao usuarioDao;
    private final UsuarioMapper usuarioMapper;
    public  AdminServiceImpl(UsuarioDao usuarioDao, UsuarioMapper usuarioMapper) {
        this.usuarioDao = usuarioDao;
        this.usuarioMapper = usuarioMapper;
    }
    @Transactional
    @Override
    public void save(PostAdminDTO dto) {
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario.setCargo(Cargo.ADMIN);
        this.usuarioDao.save(usuario);
    }

    @Override
    public List<GetUsuariosDTO> findAll() {
        return this.usuarioDao.findAllByCargo(Cargo.ADMIN)
                .stream()
                .map(this.usuarioMapper::toDto)
                .toList();
    }
}
