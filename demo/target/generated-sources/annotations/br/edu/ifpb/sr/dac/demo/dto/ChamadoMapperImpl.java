package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import br.edu.ifpb.sr.dac.demo.model.PrioridadeChamado;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-22T21:27:56-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
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
        Integer prioridade = null;

        titulo = chamado.getTitulo();
        descricao = chamado.getDescricao();
        if ( chamado.getPrioridade() != null ) {
            prioridade = chamado.getPrioridade().ordinal();
        }

        PostChamadoDTO postChamadoDTO = new PostChamadoDTO( titulo, descricao, prioridade );

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
        if ( dto.prioridade() != null ) {
            chamado.setPrioridade( PrioridadeChamado.values()[ dto.prioridade() ] );
        }

        return chamado;
    }
}
