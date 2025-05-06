package com.homeworkProject.models;
public class UserHomework {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String confirmPassword;

    public UserHomework setEmail(String email) {
        this.email = email;
        return this;
    }
    public  UserHomework setPassword(String password) {
        this.password = password;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserHomework setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserHomework setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserHomework setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}