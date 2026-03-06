package br.edu.ifpb.sr.dac.demo.dto;

import java.time.LocalDateTime;

public record GetChamadosDTO(Long id, String titulo, String descricao, LocalDateTime dataAbertura) {
}
