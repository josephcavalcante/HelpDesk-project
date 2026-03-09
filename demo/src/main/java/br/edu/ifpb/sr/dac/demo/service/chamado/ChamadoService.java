package br.edu.ifpb.sr.dac.demo.service.chamado;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;

import java.util.List;

public interface ChamadoService {
    void save(PostChamadoDTO dto);
    List<GetChamadosDTO> findAllByUsuario(Long idUsuario);
}
