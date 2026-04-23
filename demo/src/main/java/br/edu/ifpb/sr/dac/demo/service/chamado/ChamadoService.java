package br.edu.ifpb.sr.dac.demo.service.chamado;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChamadoService {
    Long save(PostChamadoDTO dto, Long idUsuario);
    Page<GetChamadosDTO> findAllByUsuario(Long idUsuario, Pageable pageable);
}
