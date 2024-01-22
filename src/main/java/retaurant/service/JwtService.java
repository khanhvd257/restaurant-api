package retaurant.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import retaurant.entity.User;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

//    @Value("${}")
    private static final String SECRET_KEY = "123";
    public String generatorToken(User user, Collection<SimpleGrantedAuthority> authorities){
        Algorithm  algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        return JWT.create().
                withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 1000 *60))
                .withClaim("roles", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }
    public String generatorRefreshToken(User user){
        Algorithm  algorithm = Algorithm.HMAC256(SECRET_KEY.getBytes());
        return JWT.create().withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 900 * 1000 *60))
                .sign(algorithm);
    }
}
