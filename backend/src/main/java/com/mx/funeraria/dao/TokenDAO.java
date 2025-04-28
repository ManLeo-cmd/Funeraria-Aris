package com.mx.funeraria.dao;

import com.mx.funeraria.entidades.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenDAO extends JpaRepository<Token, Integer> {

    List<Token> findAllValidIsFalseOrRevokedIsFalseByClienteId(int clienteId);

    Optional<Token> findByToken(String token);

}
