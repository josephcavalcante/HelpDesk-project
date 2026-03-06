package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.service.ChamadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/chamados")
public class ChamadoController {
    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping
    public ResponseEntity<Boolean> postChamado(@RequestBody PostChamadoDTO dto) {
        this.chamadoService.save(dto);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/usuario/:id")
    public ResponseEntity<List<GetChamadosDTO>> getChamados(@PathVariable Long id) {
        return ResponseEntity.ok(this.chamadoService.findAllByUsuario(id));
    }
}
