package com.genius.shoppingListDemo.dto;

public class SuperMarketDetailsDTO {
    private Integer id;
    private String address;
    private String phoneNumber;

    public SuperMarketDetailsDTO() {}

    public SuperMarketDetailsDTO(Integer id, String address, String phoneNumber) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

