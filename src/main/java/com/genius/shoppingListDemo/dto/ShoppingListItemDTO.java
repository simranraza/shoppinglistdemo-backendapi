package com.genius.shoppingListDemo.dto;

import javax.persistence.criteria.CriteriaBuilder.In;

public class ShoppingListItemDTO {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private boolean purchased;
    private Integer quantity;
    private Integer shoppingEventId;

    public ShoppingListItemDTO() {}

    public ShoppingListItemDTO(Integer id, String name, String description, String category, boolean purchased, Integer quantity, Integer shoppingEventId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.purchased = purchased;
        this.quantity = quantity;
        this.shoppingEventId = shoppingEventId;
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

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getShoppingEventId() {
        return shoppingEventId;
    }
    public void setShoppingEventId(Integer shoppingEventId) {
        this.shoppingEventId = shoppingEventId;
    }
}
