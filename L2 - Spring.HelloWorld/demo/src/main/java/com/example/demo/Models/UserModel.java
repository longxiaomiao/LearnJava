package com.example.demo.Models;

public class UserModel{
    public UserModel(String _name,String _address){
        setName(_name);
        setAddress(_address);
    }

    private String name;
    private String address;

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

}