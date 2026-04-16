package br.edu.ifpb.sr.dac.demo.dao;

import br.edu.ifpb.sr.dac.demo.model.Cargo;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Page<Usuario> findAllByCargo(Cargo cargo, Pageable page);

    Boolean existsByCpf(@CPF String cpf);

    boolean existsByUsername(@NotBlank(message = "username não pode ser vazio") String username);
}
