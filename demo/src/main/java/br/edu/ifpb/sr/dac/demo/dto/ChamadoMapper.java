package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper (componentModel = "spring")
public interface ChamadoMapper {

    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "usuario.nome", target = "nomeUsuario")
    ChamadoResponseDTO toResponseDTO(Chamado chamado);

    Chamado toEntity(ChamadoRequestDTO dto);
}
