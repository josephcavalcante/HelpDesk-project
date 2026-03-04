package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.ChamadoRequestDTO;
import br.edu.ifpb.sr.dac.demo.dto.ChamadoResponseDTO;
import br.edu.ifpb.sr.dac.demo.service.ChamadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/chamados")
@RequiredArgsConstructor
public class ChamadoController {

    private final ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ChamadoResponseDTO> criar(
            @RequestBody @Valid ChamadoRequestDTO dto,
            UriComponentsBuilder uriBuilder
            ){
        ChamadoResponseDTO criado = chamadoService.criar(dto);

        URI uri = uriBuilder.path("/v1/chamados/{id}").buildAndExpand(criado.id()).toUri();

        return ResponseEntity.created(uri).body(criado);
    }
    @GetMapping
    public  ResponseEntity<List<ChamadoResponseDTO>> listar(){
        return ResponseEntity.ok(chamadoService.listarTodos());
    }
}
