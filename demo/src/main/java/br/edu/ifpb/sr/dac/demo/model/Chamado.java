package br.edu.ifpb.sr.dac.demo.model;

import br.edu.ifpb.sr.dac.demo.model.enums.StatusChamado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String descricao;
    private StatusChamado status;
}
