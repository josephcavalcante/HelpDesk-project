package br.edu.ifpb.sr.dac.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record ChamadoRequestDTO(
        @NotBlank(message = "O título é obrigatório")
        String titulo,
        @NotBlank(message = "A descrição é obrigatória")
        String descricao,
        @NotBlank(message = "O ID do usuário é obrigatório")
        Long usuarioId
) {
}
