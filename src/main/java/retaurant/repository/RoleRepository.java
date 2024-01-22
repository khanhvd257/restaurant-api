package retaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import retaurant.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String roleName);
}
