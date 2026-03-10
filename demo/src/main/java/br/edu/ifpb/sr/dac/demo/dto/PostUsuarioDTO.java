package br.edu.ifpb.sr.dac.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

public record PostUsuarioDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter no mínimo 3 caracteres")
        String nome,

        @NotBlank(message = "O username é obrigatório")
        String username,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O formato do e-mail é inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, max = 100, message = "A senha deve ter no mínimo 8 caracteres")
        String senha,

        @NotBlank(message = "A confirmação de senha é obrigatória")
        @Size(min = 8, max = 100, message = "A senha deve ter no mínimo 8 caracteres")
        String confirmacaoSenha,

        @NotNull(message = "O id do Admin é obrigatório")
        @Positive(message = "O id do Admin deve ser um número positivo")
        Long idUsuario) {
}
