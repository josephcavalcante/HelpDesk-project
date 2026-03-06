package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostAdminDTO;
import br.edu.ifpb.sr.dac.demo.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Boolean> postAdmin(@RequestBody PostAdminDTO dto) {
        this.adminService.save(dto);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping
    public ResponseEntity<List<GetUsuariosDTO>> getAdmins() {
        return ResponseEntity.ok(this.adminService.findAll());
    }
}
