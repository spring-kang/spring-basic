package com.hackers.mycommerce.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
