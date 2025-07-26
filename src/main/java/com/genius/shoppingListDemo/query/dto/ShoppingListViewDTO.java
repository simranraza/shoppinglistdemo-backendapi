package com.genius.shoppingListDemo.query.dto;

import java.time.LocalDateTime;

public class ShoppingListViewDTO {
    private String itemName;
    private String description;
    private String category;
    private Integer quantity;
    private LocalDateTime shoppingDate;
    private String superMarketName;
    private String superMarketAddress;

    // Constructors
    public ShoppingListViewDTO() {}

    public ShoppingListViewDTO(String itemName, String description, String category, Integer quantity,
                               LocalDateTime shoppingDate, String superMarketName, String superMarketAddress) {
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.shoppingDate = shoppingDate;
        this.superMarketName = superMarketName;
        this.superMarketAddress = superMarketAddress;
    }

    // Getters and Setters
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
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
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public LocalDateTime getShoppingDate() {
        return shoppingDate;
    }
    public void setShoppingDate(LocalDateTime shoppingDate) {
        this.shoppingDate = shoppingDate;
    }
    public String getSuperMarketName() {
        return superMarketName;
    }
    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }
    public String getSuperMarketAddress() {
        return superMarketAddress;
    }
    public void setSuperMarketAddress(String superMarketAddress) {
        this.superMarketAddress = superMarketAddress;
    }
}
