package com.genius.shoppingListDemo.repository;

import com.genius.shoppingListDemo.entity.SuperMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperMarketRepository extends JpaRepository<SuperMarket, Integer> {
}