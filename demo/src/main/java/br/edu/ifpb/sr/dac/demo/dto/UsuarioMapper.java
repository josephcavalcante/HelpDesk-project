package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    GetUsuariosDTO toDto(Usuario usuario);

    Usuario toEntity(GetUsuariosDTO userDTO);

    @Mapping(target = "confirmacaoSenha", ignore = true)
    PostUsuarioDTO toPostUsuarioDto(Usuario usuario);

    Usuario toUsuarioEntity(PostUsuarioDTO dto);
}
