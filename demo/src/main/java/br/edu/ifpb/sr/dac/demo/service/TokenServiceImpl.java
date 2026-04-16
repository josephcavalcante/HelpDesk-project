package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.security.Key;

import java.time.Instant;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    private final String SECRET = "my-32-character-ultra-secure-and-ultra-long-secret";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
 public String generateToken(Authentication authetication){
     Instant now = Instant.now();
     Instant expiration = now.plusSeconds(1800);
     return Jwts
             .builder()
             .setSubject(authetication.getName())
             .claim("roles", authetication.getAuthorities())
             .setIssuedAt(Date.from(now))
             .expiration(Date.from(expiration))
             .signWith(key)
             .compact();


 }

}
