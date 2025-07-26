package com.genius.shoppingListDemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_ShoppingListItems")
public class ShoppingListItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_name",length = 128, nullable = true)
    private String itemName;

    @Column(length = 256)
    private String description;

    @Column(length = 256, nullable = true)
    private String category;

    @Column(nullable = true, columnDefinition = "boolean default false" )
    private boolean purchased;

    @ManyToOne
    @JoinColumn(name = "shopping_event_id")
    private ShoppingEvent shoppingEvent;

    @Column(nullable = true, columnDefinition = "integer default 1")
    private Integer quantity;


    public ShoppingListItemEntity(){}

 

    public ShoppingListItemEntity(Integer id, String itemName, String description, String category, boolean purchased,
            ShoppingEvent shoppingEvent, Integer quantity) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.purchased = purchased;
        this.shoppingEvent = shoppingEvent;
        this.quantity = quantity;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

        public ShoppingEvent getShoppingEvent() {
        return shoppingEvent;
    }

    public void setShoppingEvent(ShoppingEvent shoppingEvent) {
        this.shoppingEvent = shoppingEvent;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


