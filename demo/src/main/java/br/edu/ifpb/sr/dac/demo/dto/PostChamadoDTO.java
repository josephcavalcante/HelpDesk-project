package br.edu.ifpb.sr.dac.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PostChamadoDTO(
        @NotBlank(message = "O titulo é obrigatório")
        String titulo,
        @NotBlank(message = "A descrição é obrigatória")
        String descricao,
        @NotNull(message = "O usuário é obrigatório")
        @Positive(message = "O usuário deve ser um número positivo")
        Long idUsuario) {
}
