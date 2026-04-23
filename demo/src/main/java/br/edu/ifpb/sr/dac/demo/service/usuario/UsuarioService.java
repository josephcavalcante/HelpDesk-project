package br.edu.ifpb.sr.dac.demo.service.usuario;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService extends UserDetailsService {
    Long save(PostUsuarioDTO dto);

    Long saveAdmin(PostUsuarioDTO dto, Long idRegistrador);

    List<GetUsuariosDTO> findAll();

    Page<GetUsuariosDTO> findAllAdmin(Pageable pageable);

}
