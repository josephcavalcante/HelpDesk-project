package br.edu.ifpb.sr.dac.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostUsuarioDTO implements Serializable {
    private String nome;
    private String username;
    private String senha;
    private String confirmacaoSenha;
}
