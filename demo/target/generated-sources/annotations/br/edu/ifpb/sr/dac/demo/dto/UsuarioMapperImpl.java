package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T12:30:11-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260128-0750, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public GetUsuariosDTO toDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String username = null;

        id = usuario.getId();
        nome = usuario.getNome();
        username = usuario.getUsername();

        GetUsuariosDTO getUsuariosDTO = new GetUsuariosDTO( id, nome, username );

        return getUsuariosDTO;
    }

    @Override
    public Usuario toEntity(GetUsuariosDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( userDTO.id() );
        usuario.setNome( userDTO.nome() );
        usuario.setUsername( userDTO.username() );

        return usuario;
    }

    @Override
    public PostUsuarioDTO toPostUsuarioDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String nome = null;
        String username = null;
        String email = null;
        String senha = null;

        nome = usuario.getNome();
        username = usuario.getUsername();
        email = usuario.getEmail();
        senha = usuario.getSenha();

        String confirmacaoSenha = null;
        Long idUsuario = null;

        PostUsuarioDTO postUsuarioDTO = new PostUsuarioDTO( nome, username, email, senha, confirmacaoSenha, idUsuario );

        return postUsuarioDTO;
    }

    @Override
    public Usuario toUsuarioEntity(PostUsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNome( dto.nome() );
        usuario.setUsername( dto.username() );
        usuario.setSenha( dto.senha() );
        usuario.setEmail( dto.email() );

        return usuario;
    }
}
