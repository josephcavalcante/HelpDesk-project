package br.edu.ifpb.sr.dac.demo.service.chamado;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.model.StatusChamado;

import java.util.List;

public interface ChamadoService {
    void save(PostChamadoDTO dto);
    List<GetChamadosDTO> find(Long idUsuario, StatusChamado status);
}
