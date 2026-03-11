package br.edu.ifpb.sr.dac.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private PrioridadeChamado prioridade;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Usuario admin;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private StatusChamado status;

    public void setDataAbertura(LocalDateTime now) {

    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

}
