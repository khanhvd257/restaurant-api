package retaurant.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import retaurant.auth.AuthenticationRequest;
import retaurant.auth.AuthenticationResponse;
import retaurant.entity.Role;
import retaurant.entity.User;
import retaurant.repository.RoleCustomRepo;
import retaurant.repository.UserRepository;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleCustomRepo roleCustomRepo;
    private final JwtService jwtService;

    public AuthenticationResponse authentication(AuthenticationRequest authenticationRequest) throws
            AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        User user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Khong tin thay username"));
        List<Role> roles = null;
        if (user != null) {
            roles = roleCustomRepo.getRolesByUsername(user.getUsername());
//            roles = roleCustomRepo.findByUsername(user.getUsername());
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<Role> set = new HashSet<>();
        roles.stream().forEach(c -> set.add(new Role(c.getName())));
        user.setRoles(set);
        set.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getName())));
        var jwtToken = jwtService.generatorToken(user, authorities);
        var jwtRefreshToken = jwtService.generatorRefreshToken(user);
        return AuthenticationResponse.builder().token(jwtToken).refreshToken(jwtRefreshToken).build();
    }
}
