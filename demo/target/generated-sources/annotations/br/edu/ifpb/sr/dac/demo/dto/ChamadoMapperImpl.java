package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T12:20:40-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260128-0750, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class ChamadoMapperImpl implements ChamadoMapper {

    @Override
    public GetChamadosDTO toDto(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }

        Long id = null;
        String titulo = null;
        String descricao = null;
        Integer prioridade = null;

        id = chamado.getId();
        titulo = chamado.getTitulo();
        descricao = chamado.getDescricao();
        if ( chamado.getPrioridade() != null ) {
            prioridade = chamado.getPrioridade().ordinal();
        }

        LocalDateTime dataAbertura = null;

        GetChamadosDTO getChamadosDTO = new GetChamadosDTO( id, titulo, descricao, prioridade, dataAbertura );

        return getChamadosDTO;
    }

    @Override
    public PostChamadoDTO toPostChamadoDto(Chamado chamado) {
        if ( chamado == null ) {
            return null;
        }

        String titulo = null;
        String descricao = null;

        titulo = chamado.getTitulo();
        descricao = chamado.getDescricao();

        Long idUsuario = null;

        PostChamadoDTO postChamadoDTO = new PostChamadoDTO( titulo, descricao, idUsuario );

        return postChamadoDTO;
    }

    @Override
    public Chamado toEntity(PostChamadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Chamado chamado = new Chamado();

        chamado.setTitulo( dto.titulo() );
        chamado.setDescricao( dto.descricao() );

        return chamado;
    }
}
