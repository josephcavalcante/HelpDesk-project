package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    GetUsuariosDTO toDto(Usuario usuario);

    Usuario toEntity(GetUsuariosDTO userDTO);

    PostUsuarioDTO toPostUsuarioDto(Usuario usuario);

    Usuario toUsuarioEntity(PostUsuarioDTO dto);

}