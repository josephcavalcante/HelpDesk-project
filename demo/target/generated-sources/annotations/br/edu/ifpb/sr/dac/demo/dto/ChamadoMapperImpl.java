package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-11T19:43:27-0300",
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
        Long idUsuario = null;

        PostChamadoDTO postChamadoDTO = new PostChamadoDTO( titulo, descricao, prioridade, idUsuario );

        return postChamadoDTO;
    }

    @Override
    public Chamado toEntity(PostChamadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Chamado chamado = new Chamado();

        return chamado;
    }
}
