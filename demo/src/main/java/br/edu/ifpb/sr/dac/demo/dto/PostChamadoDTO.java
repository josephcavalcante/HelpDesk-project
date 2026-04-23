package br.edu.ifpb.sr.dac.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostChamadoDTO(
        @NotBlank(message = "titulo não pode ser vazio")
        String titulo,

        @NotBlank(message = "descrição não pode ser vazia")
        String descricao,

        @NotNull(message = "prioridade não pode ser nula")
        @Min(value = 0, message = "Prioridade deve ser positiva")
        @Max(value = 5, message = "Prioridade máxima é cinco")
        Integer prioridade
        ) {
}
