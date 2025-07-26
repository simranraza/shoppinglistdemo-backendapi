package com.genius.shoppingListDemo.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genius.shoppingListDemo.entity.ShoppingEvent;
import com.genius.shoppingListDemo.mappers.ShoppingListViewMapper;
import com.genius.shoppingListDemo.query.dto.ShoppingListViewDTO;
import com.genius.shoppingListDemo.repository.ShoppingEventRepository;

@Service
public class ShoppingListQueryService {

    private ShoppingEventRepository shoppingEventRepository;

    private ShoppingListViewMapper shoppingListViewMapper;

    @Autowired
    public ShoppingListQueryService(ShoppingEventRepository shoppingEventRepository, ShoppingListViewMapper shoppingListViewMapper) {
        this.shoppingEventRepository = shoppingEventRepository;
        this.shoppingListViewMapper = shoppingListViewMapper;
    }

    public List<ShoppingListViewDTO> getShoppingsByDateRange(LocalDate startDate, LocalDate endDate) {
        System.out.println("Fetching shopping events between " + startDate + " and " + endDate);
        LocalDateTime startDateTime = startDate.atStartOfDay();            // 00:00:00
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX); 
        List<ShoppingListViewDTO> shoppingListViews = new ArrayList<>();
        // Implementation to fetch shopping events by date range
        List<ShoppingEvent> shoppingEvents = shoppingEventRepository.findByShoppingDateBetween(startDateTime, endDateTime);
        if (shoppingEvents != null && !shoppingEvents.isEmpty()) {
            shoppingListViews = shoppingListViewMapper.toShoppingListViewDTOList(shoppingEvents);
        }
        return shoppingListViews;
    }

}
