package com.genius.shoppingListDemo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.genius.shoppingListDemo.query.ShoppingListQueryService;
import com.genius.shoppingListDemo.query.dto.ShoppingListViewDTO;

@Controller
@RequestMapping("/shopping")
public class ShoppingListViewController {

    private ShoppingListQueryService shoppingEventService;

    @Autowired
    public ShoppingListViewController(ShoppingListQueryService shoppingEventService) {
        this.shoppingEventService = shoppingEventService;   
    }

     @GetMapping("/viewShoppingItemDetailsByDateRange")
    public ResponseEntity<List<ShoppingListViewDTO>> getShoppingListByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {

        List<ShoppingListViewDTO> result = shoppingEventService.getShoppingsByDateRange(startDate, endDate);
        return ResponseEntity.ok(result);
    }

}
