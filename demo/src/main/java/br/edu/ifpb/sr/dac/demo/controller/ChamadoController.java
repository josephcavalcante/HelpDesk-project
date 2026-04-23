package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.service.chamado.ChamadoService;
import org.springframework.security.oauth2.jwt.Jwt;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/chamados")
public class ChamadoController {
    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> postChamado(@RequestBody @Valid PostChamadoDTO dto, @AuthenticationPrincipal Jwt jwt) {
        Long id = this.chamadoService.save(dto, Long.parseLong(jwt.getSubject()));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Page<GetChamadosDTO>> getAllByUsuario(
            @AuthenticationPrincipal Jwt jwt,
            @PageableDefault(size = 10, sort = "dataAbertura", direction = Sort.Direction.DESC) Pageable pageable) {
        Long idUsuario = Long.parseLong(jwt.getSubject());
        return ResponseEntity.ok(this.chamadoService.findAllByUsuario(idUsuario, pageable));
    }
}
