package com.mx.funeraria.config;

import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    // SPRING SECURITY

    @Autowired
    private ClientesService clientesService;

    @Bean
    UserDetailsService userDetailsService() throws Exception{
        return username -> {
            final Clientes clientes;
            try {
                clientes = clientesService.buscarClientePorEmail(username);
                return User.builder()
                        .username(clientes.getEmail())
                        .password(clientes.getContrasena())
                        .build();
            } catch (Exception e) {
                throw new RuntimeException("ERROR");
            }

        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
