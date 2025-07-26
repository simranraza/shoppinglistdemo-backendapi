package com.genius.shoppingListDemo.service;

import com.genius.shoppingListDemo.dto.ShoppingListItemDTO;
import com.genius.shoppingListDemo.entity.ShoppingListItemEntity;

import java.util.List;


public interface ShoppingListService {
    public List<ShoppingListItemDTO> findAll();

    public List<ShoppingListItemDTO> saveOrUpdateItems(List<ShoppingListItemDTO> itemDTOs);

    public List<ShoppingListItemDTO> findItemsByEventId(Integer shoppingEventId);
}
