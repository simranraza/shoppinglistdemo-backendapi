package com.genius.shoppingListDemo.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genius.shoppingListDemo.dto.ShoppingEventDTO;
import com.genius.shoppingListDemo.service.ShoppingEventService;
import com.genius.shoppingListDemo.service.ShoppingListService;

@Controller
@RequestMapping("/shopping")
public class ShoppingListController {
    @Autowired
    private ShoppingEventService shoppingEventService;

    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping("/{shoppingEventId}")
    @ResponseBody
    public ResponseEntity<ShoppingEventDTO> getShoppingEventById(@PathVariable Integer shoppingEventId) {
        try {
            ShoppingEventDTO dto = shoppingEventService.findById(shoppingEventId);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<ShoppingEventDTO> createShoppingEvent(@RequestBody ShoppingEventDTO shoppingEventDTO) {
        ShoppingEventDTO createdEvent = shoppingEventService.createShoppingEvent(shoppingEventDTO);
        return ResponseEntity.ok(createdEvent);
    }

    

}
