package retaurant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import retaurant.entity.Role;
import retaurant.entity.User;
import retaurant.service.UserService;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories
public class RetaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetaurantApplication.class, args);

    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(UserService userService) {
//        return args -> {
//            userService.saveRole(new Role(null, "ROLE_USER"));
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//            userService.saveRole(new Role(null, "ROLE_STAFF"));
//            userService.saveUser(new User(null, "Khanh", "123456", true, new HashSet<>()));
//            userService.saveUser(new User(null, "Tram", "12345786", true, new HashSet<>()));
//
//            userService.addRoleToUser("Khanh", "ROLE_ADMIN");
//            userService.addRoleToUser("Tram", "ROLE_USER");
//        };
//    }
}
