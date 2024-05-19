package com.cashrich.inter.dev.cryptoapp.model;

public class UpdateRequest {
    private String firstName;
    private String lastName;
    private String mobile;
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
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    private String password;
    public Long getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
    public String getEmail() {
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

}
