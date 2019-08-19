package com.codegym.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class User implements Validator {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        int age = user.getAge();
        String email = user.getEmail();

        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");

        if (firstName.length()>45 || firstName.length()<5){
            errors.rejectValue("firstName", "firstName.length");
        }
        if (lastName.length()>45 || lastName.length()<5){
            errors.rejectValue("lastName", "lastName.length");
        }
        if (phoneNumber.length()>11 || phoneNumber.length()<10) {
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }

        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("(^[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        if (age <= 18){
            errors.rejectValue("age", "age.condition");
        }

        if (!email.matches("(^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$)")){
            errors.rejectValue("email", "email.matches");
        }

    }
}