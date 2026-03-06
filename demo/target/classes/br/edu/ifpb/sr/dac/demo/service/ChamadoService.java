package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.model.Usuario;

import java.util.List;

public interface ChamadoService {
    void save(PostChamadoDTO dto);
    List<GetChamadosDTO> findAllByUsuario(Long idUsuario);
}
