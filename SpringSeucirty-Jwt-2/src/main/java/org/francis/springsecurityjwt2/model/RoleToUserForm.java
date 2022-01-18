package org.francis.springsecurityjwt2.model;

import lombok.Data;

/**
 * @author Franc1s
 * @date 2022/1/18
 * @apiNote
 */
@Data
public class RoleToUserForm {
    private String username;
    private String roleName;
}
