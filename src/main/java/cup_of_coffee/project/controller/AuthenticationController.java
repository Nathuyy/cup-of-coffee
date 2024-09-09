package cup_of_coffee.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cup_of_coffee.project.domain.user.AuthenticationDTO;
import cup_of_coffee.project.domain.user.LoginResposneDTO;
import cup_of_coffee.project.domain.user.RegisterDTO;
import cup_of_coffee.project.infra.security.TokenService;
import cup_of_coffee.project.model.Cliente;
import cup_of_coffee.project.repository.ClienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    private ClienteRepository clienteRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var clienteSenha = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(clienteSenha);

        var token = tokenService.generateToken((Cliente) auth.getPrincipal());


        return ResponseEntity.ok(new LoginResposneDTO(token));
    }


    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if (this.clienteRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        } else {
            String senhaEncriptada = new BCryptPasswordEncoder().encode(data.senha());
            
            Cliente novoCliente = new Cliente(data.email(), senhaEncriptada, data.role());
            
            this.clienteRepository.save(novoCliente);
    
            return ResponseEntity.ok().build();
        }
    }
}
