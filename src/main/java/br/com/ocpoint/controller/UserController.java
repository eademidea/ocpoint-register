package br.com.ocpoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ocpoint.service.ServiceTeste;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController("/v1/users")
@Tag(name = "UserController", description = "Gerenciamento de usuários...")
public class UserController {

    private ServiceTeste teste;

    public UserController(ServiceTeste teste) {
        this.teste = teste;
    }

    @GetMapping("/sign-in")
    @Operation
    @ApiResponses(
        @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso...")
    )
    public ResponseEntity<String> signin() {
        return ResponseEntity.ok(teste.teste());
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signup() {
        return ResponseEntity.ok(teste.teste());
    }

}
