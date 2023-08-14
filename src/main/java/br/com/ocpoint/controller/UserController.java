package br.com.ocpoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ocpoint.service.ServiceTeste;

@RestController
public class UserController {

    private ServiceTeste teste;

    public UserController(ServiceTeste teste) {
        this.teste = teste;
    }

    @GetMapping("teste")
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok(teste.teste());
    }

}
