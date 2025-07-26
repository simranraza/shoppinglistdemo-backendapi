package com.genius.shoppingListDemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_SuperMarketDetails")
public class SuperMarketDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 256)
    private String address;

    @Column(length = 32)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "super_market_id", nullable = false)
    private SuperMarket superMarket;

    

    public SuperMarketDetails() {}

    public SuperMarketDetails(Integer id, String address, String phoneNumber, SuperMarket superMarket) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.superMarket = superMarket;
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

    public SuperMarket getSuperMarket() {
        return superMarket;
    }

    public void setSuperMarket(SuperMarket superMarket) {
        this.superMarket = superMarket;
    }
}