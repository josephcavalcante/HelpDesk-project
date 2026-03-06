package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostAdminDTO;

import java.util.List;

public interface AdminService {
    void save (PostAdminDTO dto);
    List<GetUsuariosDTO> findAll();

}
