package com.genius.shoppingListDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genius.shoppingListDemo.entity.SuperMarketDetails;

import org.springframework.stereotype.Repository;

@Repository
public interface SuperMarketDetailsRepository extends JpaRepository<SuperMarketDetails, Integer> {
    // Additional query methods can be defined here if needed

}
// This repository interface extends JpaRepository to provide CRUD operations for SuperMarketDetails entity.