package com.example.springextenddemo.vo;


import java.util.StringJoiner;

public class UserVO {

    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserVO.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("address='" + address + "'")
                .add("age=" + age)
                .toString();
    }
}
