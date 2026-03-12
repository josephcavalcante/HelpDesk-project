package br.edu.ifpb.sr.dac.demo.dao.specs;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import br.edu.ifpb.sr.dac.demo.model.StatusChamado;
import org.springframework.data.jpa.domain.Specification;

public class ChamadoSpecs {

    public static Specification<Chamado> usuarioIgual(Long usuarioId){
        return (root, query, builder) ->
                usuarioId == null ? null : builder.equal(root.get("usuario").get("id"), usuarioId);
    }
    public static Specification<Chamado> statusIgual(StatusChamado status) {
        return (root, query, builder) ->
                status == null ? null : builder.equal(root.get("status"), status);
    }
}
