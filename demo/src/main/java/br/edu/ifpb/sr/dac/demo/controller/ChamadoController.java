package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetChamadosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.service.chamado.ChamadoService;
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
    public void postChamado(@RequestBody PostChamadoDTO dto) {
        this.chamadoService.save(dto);
    }

    @GetMapping("/usuario/:id")
    public ResponseEntity<List<GetChamadosDTO>> getAllByUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(this.chamadoService.findAllByUsuario(idUsuario));
    }
}
