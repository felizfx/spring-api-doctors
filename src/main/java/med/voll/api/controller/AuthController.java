package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.user.User;
import med.voll.api.domain.user.dto.DtoDadosAuthUser;
import med.voll.api.infra.security.JWT.TokenService;
import med.voll.api.infra.security.JWT.dto.JwtData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DtoDadosAuthUser json){
        var authToken = new UsernamePasswordAuthenticationToken(json.login(), json.password());
        var auth = manager.authenticate(authToken);

        var jwtToken = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new JwtData(jwtToken));
    }
}
