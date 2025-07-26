package com.genius.shoppingListDemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_SuperMarket")
public class SuperMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 128, nullable = false)
    private String name;

    @OneToMany(mappedBy = "superMarket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SuperMarketDetails> details;


    public SuperMarket() {}

    public SuperMarket(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SuperMarketDetails> getDetails() {
    return details;
    }

    public void setDetails(List<SuperMarketDetails> details) {
        this.details = details;
    }
}