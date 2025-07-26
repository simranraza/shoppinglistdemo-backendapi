package com.genius.shoppingListDemo.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genius.shoppingListDemo.entity.ShoppingEvent;

@Repository
public interface ShoppingEventRepository extends JpaRepository<ShoppingEvent, Integer> {
    
    // Additional query methods can be defined here if needed
    // For example, to find events by a specific attribute:
    // List<ShoppingEvent> findByEventName(String eventName);
    
    // find events by a date range:
    List<ShoppingEvent> findByShoppingDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
