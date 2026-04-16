package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import org.springframework.security.core.Authentication;

public interface TokenService {
    public String generateToken(Authentication authetication);
}
