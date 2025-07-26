package com.genius.shoppingListDemo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ShoppingEventDTO {
    private Integer id;
    private LocalDateTime shoppingDate;
    private String description;
    private SuperMarketDetailsDTO superMarketDetail;
    private List<ShoppingListItemDTO> shoppingListItems;

    public ShoppingEventDTO() {}

    public ShoppingEventDTO(Integer id, LocalDateTime shoppingDate, String description,
                            SuperMarketDetailsDTO superMarketDetail,
                            List<ShoppingListItemDTO> shoppingListItems) {
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

    public SuperMarketDetailsDTO getSuperMarketDetail() {
        return superMarketDetail;
    }

    public void setSuperMarketDetail(SuperMarketDetailsDTO superMarketDetail) {
        this.superMarketDetail = superMarketDetail;
    }

    public List<ShoppingListItemDTO> getShoppingListItems() {
        return shoppingListItems;
    }

    public void setShoppingListItems(List<ShoppingListItemDTO> shoppingListItems) {
        this.shoppingListItems = shoppingListItems;
    }
}
