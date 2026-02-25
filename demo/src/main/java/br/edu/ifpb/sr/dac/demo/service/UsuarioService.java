package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;

import java.util.List;

public interface UsuarioService {
    void save(PostUsuarioDTO dto);
    List<GetUsuariosDTO> findAll();
}
