package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-11T19:43:27-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
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

        return usuario;
    }

    @Override
    public PostUsuarioDTO toPostUsuarioDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String nome = null;
        String username = null;

        nome = usuario.getNome();
        username = usuario.getUsername();

        String confirmacaoSenha = null;
        Long idUsuario = null;
        String email = null;
        String cpf = null;
        String senha = null;

        PostUsuarioDTO postUsuarioDTO = new PostUsuarioDTO( nome, username, email, cpf, senha, confirmacaoSenha, idUsuario );

        return postUsuarioDTO;
    }

    @Override
    public Usuario toUsuarioEntity(PostUsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        return usuario;
    }
}
