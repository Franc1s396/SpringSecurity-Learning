package org.francis.springsecurityjwt2.repo;

import org.francis.springsecurityjwt2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Franc1s
 * @date 2022/1/18
 * @apiNote
 */
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
