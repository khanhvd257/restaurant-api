package retaurant.repository;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import retaurant.entity.Role;

import java.util.List;

@Repository
public interface RoleCustomRepo extends JpaRepository<Role, Long> {


    @Query(value = "SELECT r.id, r.name " +
            "FROM users u " +
            "JOIN users_role ur ON u.id = ur.users_id " +
            "JOIN roles r ON r.id = ur.roles_id " +
            "WHERE u.username = ?1", nativeQuery = true)
    List<Role> getRolesByUsername(String username);
}
