package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.validation.SenhasIguais;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
@SenhasIguais
public record PostUsuarioDTO (
        @NotBlank(message = "O nome não pode ser vazio")
        String nome,

        @NotBlank(message = "O username (e-mail) não pode ser vazio")
        @Email(message = "Formato de e-mail inválido")
        String username,

        @NotBlank(message = "A senha não pode ser vazia")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
        String senha,

        @NotBlank(message = "A senha não pode ser vazia")
        String confirmacaoSenha)  {
}
