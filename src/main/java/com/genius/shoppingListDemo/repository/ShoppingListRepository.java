package com.genius.shoppingListDemo.repository;

import com.genius.shoppingListDemo.entity.ShoppingListItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingListItemEntity, Integer> {
    List<ShoppingListItemEntity> findAll();
    List<ShoppingListItemEntity> findByShoppingEventId(Integer shoppingEventId);
}
