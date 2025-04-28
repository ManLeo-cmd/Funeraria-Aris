package com.mx.funeraria.services;

import com.mx.funeraria.dao.TokenDAO;
import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.entidades.Token;
import com.mx.funeraria.entidades.req.LoginRequest;
import com.mx.funeraria.entidades.req.RegisterRequest;
import com.mx.funeraria.entidades.res.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private TokenDAO tokenDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager manager;

    public void register(RegisterRequest request){
        Clientes clientes = new Clientes();
        clientes.setNombre(request.name());
        clientes.setTelefono(request.telefono());
        clientes.setEmail(request.email());
        clientes.setContrasena(passwordEncoder.encode(request.password()));
        clientes.setDireccion(request.direccion());
        clientesService.guardarCliente(clientes);
    }

    public TokenResponse login(LoginRequest request){
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        Clientes clientes = null;
        try {
            clientes = clientesService.buscarClientePorEmail(request.email());
            var jwtToken = jwtService.generateToken(clientes);
            var refreshToken = jwtService.generateRefreshToken(clientes);
            revokeAllUserTokens(clientes);
            saveUserToken(clientes, jwtToken);
            return new TokenResponse(jwtToken, refreshToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void revokeAllUserTokens(Clientes clientes){
        final List<Token> validUserTokens = tokenDAO
                .findAllValidIsFalseOrRevokedIsFalseByClienteId(clientes.getId());
        if(!validUserTokens.isEmpty()){
            for(final Token token : validUserTokens){
                token.setExpired(true);
                token.setRevoked(true);
            }
            tokenDAO.saveAll(validUserTokens);
        }
    }

    public void saveUserToken(Clientes clientes, String jwtToken){
        Token token = new Token();
        token.setCliente(clientes);
        token.setToken(jwtToken);
        token.setTokenType(Token.TokenType.BEARER);
        token.setExpired(false);
        token.setRevoked(false);

        tokenDAO.save(token);
    }

    public TokenResponse refreshToken(final String authHeader){
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new IllegalArgumentException("Invalid Bearer token");
        }

        final String refreshToken = authHeader.substring(7);
        final String user = jwtService.extractUsername(refreshToken);

        if(user == null){
            throw new IllegalArgumentException("Invalid Refresh Token");
        }

        final Clientes clientesx;
        try {
            clientesx = clientesService.buscarClientePorEmail(user);
        } catch (Exception e) {
            throw new RuntimeException("USER NOT FOUND");
        }

        if(!jwtService.isTokenValid(refreshToken, clientesx)){
            throw new IllegalArgumentException("Invalid Refresh Token");
        }

        final String accessToken = jwtService.generateToken(clientesx);
        revokeAllUserTokens(clientesx);
        saveUserToken(clientesx, accessToken);
        return new TokenResponse(accessToken, refreshToken);

    }

    public boolean findToken(String token){
        final Token tok = tokenDAO.findByToken(token).orElse(null);
        return tok != null && !tok.isExpired() && !tok.isRevoked();
    }

    public Token obtainUser(String token){
        return tokenDAO.findByToken(token).orElse(null);
    }



}
