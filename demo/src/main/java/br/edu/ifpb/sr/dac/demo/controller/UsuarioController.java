package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Boolean> postUsuario(@RequestBody PostUsuarioDTO dto) {
        System.out.println("Nome: " + dto.nome());
        this.usuarioService.save(dto);
        return ResponseEntity.created(URI.create("/1")).body(Boolean.TRUE);
    }

    @GetMapping
    public ResponseEntity<List<GetUsuariosDTO>> getUsuarios() {
        return ResponseEntity.ok(this.usuarioService.findAll());
    }
}
