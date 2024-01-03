package com.springboot.demo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Length(max = 10, message = "用户名长度不能超过10")
    @Column(nullable = false, unique = true)
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Column(nullable = false)
    private String password;

    @Max(value = 120, message = "最大年龄小于120")
    @Min(value = 1, message = "最小年龄大于1")
    @Column(nullable = false)
    private int age;

}