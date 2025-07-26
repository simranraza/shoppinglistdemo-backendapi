package com.genius.shoppingListDemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
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
import com.genius.shoppingListDemo.dto.ShoppingListItemDTO;
import com.genius.shoppingListDemo.service.ShoppingEventService;
import com.genius.shoppingListDemo.service.ShoppingListService;

@Controller
@RequestMapping("/shoppingitems")
public class ShoppingListItemsController {

    
   

    
    private ShoppingListService shoppingListService;

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct ShoppingListService initialized" );
    }

    @Autowired
    public ShoppingListItemsController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }


    @PostMapping("/createOrUpdate")
    @ResponseBody
    public ResponseEntity<List<ShoppingListItemDTO>> createOrUpdateShoppingListItems(@RequestBody List<ShoppingListItemDTO> itemDTOs) {
        List<ShoppingListItemDTO> savedItems = shoppingListService.saveOrUpdateItems(itemDTOs);
        return ResponseEntity.ok(savedItems);
    }

    @GetMapping("/{shoppingEventId}")
    @ResponseBody
    public ResponseEntity<List<ShoppingListItemDTO>> getShoppingListItemsByEventId(@PathVariable Integer shoppingEventId) {
        try {
            List<ShoppingListItemDTO> items = shoppingListService.findItemsByEventId(shoppingEventId);
            return ResponseEntity.ok(items);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
