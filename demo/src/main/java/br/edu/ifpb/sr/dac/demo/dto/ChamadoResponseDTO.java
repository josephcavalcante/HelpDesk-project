package br.edu.ifpb.sr.dac.demo.dto;

import java.time.LocalDateTime;

public record ChamadoResponseDTO(
        Long id,
        String titulo,
        String descricao,
        String status,
        LocalDateTime dataCriacao,
        Long usuarioId,
        String nomeUsuario //
) {}