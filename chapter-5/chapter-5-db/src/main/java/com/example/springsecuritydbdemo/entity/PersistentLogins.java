package com.example.springsecuritydbdemo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PersistentLogins {

    private String series;
    private String username;
    private String token;
    private Date last_used;

}