package com.hackers.mycommerce.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user_tbl")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;

    private String encPassword;

    @Enumerated(EnumType.STRING)
    private AgeType ageType;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserRole> roles = new ArrayList<>();

    public void giveUserRoles(List<UserRole> roles) {
        this.roles = roles;
        roles.forEach(userRole -> userRole.setUser(this));
    }
}
