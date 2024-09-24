package com.example.getdata.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "login")
@Getter
@Setter
public class login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String emailId;
    String password;
}
