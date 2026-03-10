package br.edu.ifpb.sr.dac.demo.dao;

import br.edu.ifpb.sr.dac.demo.model.Cargo;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Page<Usuario> findAllByCargo(Cargo cargo, Pageable page);
}
