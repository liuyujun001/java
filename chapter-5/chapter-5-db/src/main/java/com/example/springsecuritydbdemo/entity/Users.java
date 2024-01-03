package com.example.springsecuritydbdemo.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Users {

    private Integer id;
    private String username;
    private String password;

    private Set<Authorities> authorities = new HashSet<>();

}