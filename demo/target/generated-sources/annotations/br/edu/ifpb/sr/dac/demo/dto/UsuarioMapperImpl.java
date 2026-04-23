package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-22T21:27:56-0300",
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
        String cpf = null;
        String senha = null;

        nome = usuario.getNome();
        username = usuario.getUsername();
        email = usuario.getEmail();
        cpf = usuario.getCpf();
        senha = usuario.getSenha();

        String confirmacaoSenha = null;

        PostUsuarioDTO postUsuarioDTO = new PostUsuarioDTO( nome, username, email, cpf, senha, confirmacaoSenha );

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
        usuario.setEmail( dto.email() );
        usuario.setSenha( dto.senha() );
        usuario.setCpf( dto.cpf() );

        return usuario;
    }
}
