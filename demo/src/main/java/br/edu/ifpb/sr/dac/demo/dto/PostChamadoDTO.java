package br.edu.ifpb.sr.dac.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostChamadoDTO(
        @NotBlank(message = "titulo não pode ser vazio")
        String titulo,

        @NotBlank(message = "descrição não pode ser vazia")
        String descricao,

        @NotNull(message = "prioridade não pode ser nula")
        Integer prioridade,

        @NotNull(message = "idUsuario não pode ser nulo")
        Long idUsuario) {
}
