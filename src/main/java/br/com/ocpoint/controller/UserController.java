package br.com.ocpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ocpoint.model.User;
import br.com.ocpoint.model.request.LoginRequest;
import br.com.ocpoint.model.request.UserRequest;
import br.com.ocpoint.model.response.UserResponse;
import br.com.ocpoint.service.TokenService;
import br.com.ocpoint.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "UserController", description = "Gerenciamento de usuários...")
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @Operation(description = "Endpoint de login dos usuários..")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso...")
    @PostMapping("/sign-in")
    public ResponseEntity<String> signin(@RequestBody @Valid LoginRequest login) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.userName(), login.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }

    @Operation(description = "Endpoint de cadastro de usuários..")
    @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso...")
    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> signup(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(service.createUser(userRequest));
    }

    @Operation(description = "Endpoint de login dos usuários..")
    @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso...")
    @PostMapping("/teste")
    public ResponseEntity<String> teste() {

        return ResponseEntity.ok("teste");
    }

}
