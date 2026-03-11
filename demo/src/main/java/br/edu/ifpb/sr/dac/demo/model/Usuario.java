package br.edu.ifpb.sr.dac.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Objects;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (nullable = false)
    private String nome;
    
    @Column (nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String email;
    
    @Column (nullable = false)
    private String senha;
    
    @Column(nullable = false)
    @CPF
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    public Cargo getCargo(){
        return this.cargo;
    }
    public void setCargo(Cargo cargo){
        this.cargo=cargo;
    }
    public Long getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getUsername(){
        return this.username;
    }

}
