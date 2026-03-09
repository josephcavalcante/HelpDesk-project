package br.edu.ifpb.sr.dac.demo.service.usuario;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;

import java.util.List;

public interface UsuarioService {
    void save(PostUsuarioDTO dto);
    void saveAdmin(PostUsuarioDTO dto);
    List<GetUsuariosDTO> findAll();
    List<GetUsuariosDTO> findAllAdmin();

}
