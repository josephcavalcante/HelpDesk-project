package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    private final Key key;

    public TokenServiceImpl(@Value("${JWT_SECRET_KEY}") String secret) {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Instant now = Instant.now();
        Instant expiration = now.plusSeconds(1800);
        
        return Jwts.builder()
                .setSubject(usuario.getId().toString())
                .claim("username", usuario.getUsername())
                .claim("roles", authentication.getAuthorities())
                .setIssuedAt(Date.from(now))
                .expiration(Date.from(expiration))
                .signWith(key)
                .compact();
    }

}
