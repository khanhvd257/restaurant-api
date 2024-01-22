package retaurant.service;

import org.springframework.data.domain.Page;
import retaurant.entity.Role;
import retaurant.entity.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);

    Page<User> getAllUser(int page, int size);
}
