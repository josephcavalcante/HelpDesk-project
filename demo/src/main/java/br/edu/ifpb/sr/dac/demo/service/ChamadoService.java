package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dto.ChamadoRequestDTO;
import br.edu.ifpb.sr.dac.demo.dto.ChamadoResponseDTO;
import java.util.List;

public interface ChamadoService {
    ChamadoResponseDTO criar(ChamadoRequestDTO dto);
    List<ChamadoResponseDTO> listarTodos();
}
