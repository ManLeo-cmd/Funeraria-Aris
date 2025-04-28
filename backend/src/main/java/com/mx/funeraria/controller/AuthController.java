package com.mx.funeraria.controller;

import com.mx.funeraria.entidades.req.LoginRequest;
import com.mx.funeraria.entidades.req.RegisterRequest;
import com.mx.funeraria.entidades.res.TokenResponse;
import com.mx.funeraria.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody final LoginRequest request){
        final TokenResponse token = authService.login(request);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> login(@RequestBody final RegisterRequest request){
        authService.register(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/find")
    public ResponseEntity<?> validToken(@RequestBody String token){
        if(authService.findToken(token)){
            return ResponseEntity.ok(authService.findToken(token));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> obtainUser(@RequestBody String token){
        if(authService.findToken(token)){
            return ResponseEntity.ok(authService.obtainUser(token));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
