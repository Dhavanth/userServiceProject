package org.example.userserviceproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SecondaryTable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel{

    private String userName;
    private String email;
    private String hashPassword;
    @ManyToMany
    private List<Role> roles;
    private boolean isVerified;// Email verification
}
