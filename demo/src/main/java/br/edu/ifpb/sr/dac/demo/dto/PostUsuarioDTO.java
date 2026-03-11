package br.edu.ifpb.sr.dac.demo.dto;

import lombok.Data;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record PostUsuarioDTO(

        @NotBlank(message = "nome não pode ser vazio")
        String nome,

        @NotBlank(message = "username não pode ser vazio")
        String username,

        @NotBlank(message = "email não pode ser vazio")
        @Email(message = "formato do email inválido")
        String email,
        
        @CPF(message = "CPF inválido")
        @NotBlank(message = "CPF não pode ser vazio")
        String cpf,

        @NotBlank(message = "senha não pode ser vazio")
        @Size(min = 6, max = 12, message = "senha deve ter entre 6 e 12 caracteres")
        String senha,

        @NotBlank(message = "confirmação de senha não pode ser vazio")
        String confirmacaoSenha,
        @NotNull(message = "idUsuario não pode ser nulo")
        Long idUsuario) {
}
