package com.codegym.model;


import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class EmployeeForm {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private Double salary;
    private MultipartFile avatar;

    private Department department;

    public EmployeeForm() {
    }

    public EmployeeForm(Long id, String name, LocalDate birthDate, String address, Double salary, Department department, MultipartFile avatar) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.salary = salary;
        this.department = department;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}