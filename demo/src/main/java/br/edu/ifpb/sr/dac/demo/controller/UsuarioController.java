package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.service.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/administrador")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> postUsuarioAdm(@RequestBody @Valid PostUsuarioDTO dto, @AuthenticationPrincipal Jwt jwt) {
        Long idRegistrador = Long.parseLong(jwt.getSubject());
        Long id = this.usuarioService.saveAdmin(dto, idRegistrador);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/usuarios/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/administrador")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<GetUsuariosDTO>> getAllUsuariosAdmin(
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(this.usuarioService.findAllAdmin(pageable));
    }
}
