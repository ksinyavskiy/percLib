package com.project.perclib.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long userId;
    @Column(name = "EMAIL", unique = true, nullable = false, length = 30)
    private String email;
    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;

    public User() {

    }
}
