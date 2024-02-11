package org.example.userserviceproject.dtos;

import jakarta.persistence.ManyToMany;
import org.example.userserviceproject.models.Role;
import org.example.userserviceproject.models.User;

import java.util.List;

public class UserDto {
    private String name;
    private String email;
    @ManyToMany
    private List<Role> roles;
    private boolean isEmailVerified;

    public static UserDto from(User user) {
        if (user == null) return null;

        UserDto userDto = new UserDto();
        userDto.email = user.getEmail();
        userDto.name = user.getUserName();
        userDto.roles = user.getRoles();
        userDto.isEmailVerified = user.isVerified();

        return userDto;
    }
}
