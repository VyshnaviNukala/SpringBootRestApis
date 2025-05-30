package com.example.sb1.entity;

public class Property {
    private int id;
    private String address;
    private String description;

    public Property() {
    }

    public Property(int id, String address, String description) {
        this.id = id;
        this.address = address;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
