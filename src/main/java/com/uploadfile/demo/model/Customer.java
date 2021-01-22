package com.uploadfile.demo.model;

public class Customer {
    private long id;
    private String name;
    private String email;
    private String address;
    private String avatar;

    public Customer() {
    }

    public Customer(long id, String name, String email, String address, String avatar) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
    }

    public Customer(long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
