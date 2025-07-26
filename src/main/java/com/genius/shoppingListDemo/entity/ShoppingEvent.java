package com.genius.shoppingListDemo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_ShoppingEvent")
public class ShoppingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "shopping_date", nullable = false)
    private LocalDateTime shoppingDate;

    @Column(length = 512)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "super_market_detail_id", nullable = false)
    private SuperMarketDetails superMarketDetail;

    @OneToMany
    @JoinColumn(name = "shopping_event_id")
    private java.util.List<ShoppingListItemEntity> shoppingListItems;

    public ShoppingEvent() {}



    

    public ShoppingEvent(Integer id, LocalDateTime shoppingDate, String description,
            SuperMarketDetails superMarketDetail, List<ShoppingListItemEntity> shoppingListItems) {
        this.id = id;
        this.shoppingDate = shoppingDate;
        this.description = description;
        this.superMarketDetail = superMarketDetail;
        this.shoppingListItems = shoppingListItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(LocalDateTime shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SuperMarketDetails getSuperMarketDetail() {
        return superMarketDetail;
    }

    public void setSuperMarketDetail(SuperMarketDetails superMarketDetail) {
        this.superMarketDetail = superMarketDetail;
    }

    public List<ShoppingListItemEntity> getShoppingListItems() {
        return shoppingListItems;
    }
    
    public void setShoppingListItems(List<ShoppingListItemEntity> shoppingListItems) {
        this.shoppingListItems = shoppingListItems;
    }

}