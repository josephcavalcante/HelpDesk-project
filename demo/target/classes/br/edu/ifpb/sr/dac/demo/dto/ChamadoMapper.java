package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {
    GetChamadosDTO toDto(Chamado chamado);
    Chamado toEntity(PostChamadoDTO dto);
}
