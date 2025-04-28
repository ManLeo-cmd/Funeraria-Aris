package com.mx.funeraria.services;

import com.mx.funeraria.entidades.Clientes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    public String extractUsername(final String token){
        final Claims jwtToken = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return jwtToken.getSubject();
    }

    public boolean isTokenValid(final String token, final Clientes clientes){
        final String email = extractUsername(token);
        return (email.equals(clientes.getEmail())) && !isTokenExpired(token);

    }

    private boolean isTokenExpired(final String token){
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(final String token){
        final Claims jwtToken = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return jwtToken.getExpiration();
    }

    public String generateToken(final Clientes clientes){
        return buildToken(clientes, jwtExpiration);
    }


    public String generateRefreshToken(final Clientes clientes){
        return buildToken(clientes, refreshExpiration);
    }

    private String buildToken(final Clientes clientes, final long expiration){
        return Jwts.builder()
                .id(String.valueOf(clientes.getId()))
                .claims(Map.of("name", clientes.getNombre()))
                .subject(clientes.getEmail())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    private SecretKey getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
