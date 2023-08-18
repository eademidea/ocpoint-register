package br.com.ocpoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ocpoint.model.User;
import br.com.ocpoint.model.request.UserRequest;
import br.com.ocpoint.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController("/v1/users")
@Tag(name = "UserController", description = "Gerenciamento de usuários...")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Operation(description = "Endpoint de login dos usuários..")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso...")
    @GetMapping("/sign-in")
    public ResponseEntity<String> signin() {
        return ResponseEntity.ok("service.teste()");
    }

    @Operation(description = "Endpoint de cadastro de usuários..")
    @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso...")
    @PostMapping("/sign-up")
    public ResponseEntity<User> signup(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(service.createUser(userRequest));
    }

}
