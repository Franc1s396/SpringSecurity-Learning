package org.francis.springsecurityjwt2.service;

import org.francis.springsecurityjwt2.model.Role;
import org.francis.springsecurityjwt2.model.User;

import java.util.List;

/**
 * @author Franc1s
 * @date 2022/1/18
 * @apiNote
 */
public interface UserService  {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
}
