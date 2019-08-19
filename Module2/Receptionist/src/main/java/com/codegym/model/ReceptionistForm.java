package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ReceptionistForm {
    private int id;
    private String name;
    private int age;
    private String address;
    private String hobby;
    private MultipartFile avatar;

    public ReceptionistForm(int id, String name, int age, String address, String hobby, MultipartFile avatar) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobby = hobby;
        this.avatar = avatar;
    }

    public ReceptionistForm() {

    }

    public ReceptionistForm(int id, String name, int age, String address, String hobies) {
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
