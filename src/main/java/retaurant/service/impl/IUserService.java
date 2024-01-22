package retaurant.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retaurant.entity.Role;
import retaurant.entity.User;
import retaurant.repository.RoleRepository;
import retaurant.repository.UserRepository;
import retaurant.service.UserService;

@Transactional
@Slf4j
@RequiredArgsConstructor
@Service
@Data
public class IUserService implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Save successfully");
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        Role newRole = roleRepository.findByName(role.getName());
        if (newRole != null) {
            log.error("Rolename is already exist!");
            return role;
        }
        log.info("Save successfully");
        return roleRepository.save(role);

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username).get();
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public Page<User> getAllUser(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAll(pageRequest);
    }

}
