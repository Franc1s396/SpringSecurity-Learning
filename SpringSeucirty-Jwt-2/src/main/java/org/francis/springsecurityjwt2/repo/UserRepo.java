package org.francis.springsecurityjwt2.repo;

import org.francis.springsecurityjwt2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Franc1s
 * @date 2022/1/18
 * @apiNote
 */
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
