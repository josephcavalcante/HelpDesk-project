package br.edu.ifpb.sr.dac.demo.service.chamado;

import br.edu.ifpb.sr.dac.demo.dao.ChamadoDao;
import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.ChamadoMapper;
import br.edu.ifpb.sr.dac.demo.dto.GetChamadosDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostChamadoDTO;
import br.edu.ifpb.sr.dac.demo.model.Chamado;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChamadoServiceImpl implements ChamadoService {
    private final ChamadoDao chamadoDao;
    private final ChamadoMapper chamadoMapper;
    private final UsuarioDao usuarioDao;

    public ChamadoServiceImpl(ChamadoDao chamadoDao, ChamadoMapper chamadoMapper, UsuarioDao usuarioDao) {
        this.chamadoDao = chamadoDao;
        this.chamadoMapper = chamadoMapper;
        this.usuarioDao = usuarioDao;
    }

    @Override
    @Transactional
    public Long save(PostChamadoDTO dto, Long idUsuario) {
        Usuario usuario = this.usuarioDao.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Dono do chamado não encontrado"));
        Chamado chamado = this.chamadoMapper.toEntity(dto);
        chamado.setUsuario(usuario);
        chamado.setDataAbertura(LocalDateTime.now());
        return this.chamadoDao.save(chamado).getId();
    }

    @Override
    public Page<GetChamadosDTO> findAllByUsuario(Long idUsuario, Pageable pageable) {
        return this.chamadoDao.findAllByUsuario_Id(idUsuario, pageable)
                .map(this.chamadoMapper::toDto);
    }
}
