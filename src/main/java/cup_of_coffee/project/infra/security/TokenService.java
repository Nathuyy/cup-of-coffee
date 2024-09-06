package cup_of_coffee.project.infra.security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import cup_of_coffee.project.model.Cliente;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Cliente user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("cupOfCoffee-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDate()) 
                    .sign(algorithm);

            return token;
        } catch (Exception e) {
            throw new RuntimeException("Error generating JWT token", e);  
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                .withIssuer("cupOfCoffee-api")
                .build()
                .verify(token)
                .getSubject();
        } catch (Exception e) {
            throw new RuntimeException("Error validating JWT token", e);  
        }
    }

    private Date generateExpirationDate() {
        LocalDateTime expirationTime = LocalDateTime.now().plusHours(24);
        return Date.from(expirationTime.toInstant(ZoneOffset.UTC));
    }
}
