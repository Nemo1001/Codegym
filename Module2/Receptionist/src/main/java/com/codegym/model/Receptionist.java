package com.codegym.model;


import java.util.List;

public class Receptionist {
    private int id;
    private String name;
    private int age;
    private String address;
    private String hobies;
    private String avatar;

    public Receptionist(int id, String name, int age, String address, String hobies, String avatar) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobies = hobies;
        this.avatar = avatar;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobies() {
        return hobies;
    }

    public void setHobies(String hobies) {
        this.hobies = hobies;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

