package com.genius.shoppingListDemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genius.shoppingListDemo.dto.ShoppingEventDTO;
import com.genius.shoppingListDemo.dto.ShoppingListItemDTO;
import com.genius.shoppingListDemo.dto.SuperMarketDetailsDTO;
import com.genius.shoppingListDemo.entity.ShoppingEvent;
import com.genius.shoppingListDemo.entity.ShoppingListItemEntity;
import com.genius.shoppingListDemo.entity.SuperMarket;
import com.genius.shoppingListDemo.entity.SuperMarketDetails;
import com.genius.shoppingListDemo.mappers.ShoppingListItemMapper;
import com.genius.shoppingListDemo.repository.ShoppingEventRepository;
import com.genius.shoppingListDemo.repository.SuperMarketDetailsRepository;
import com.genius.shoppingListDemo.repository.SuperMarketRepository;

@Service
public class ShoppingEventService {

    @Autowired
    private ShoppingEventRepository shoppingEventRepository;

    @Autowired
    private SuperMarketRepository superMarketRepository;

    @Autowired
    private ShoppingListItemMapper shoppingListItemMapper;

    @Autowired
    private SuperMarketDetailsRepository superMarketDetailsRepository;

    public ShoppingEventDTO findById(Integer id) {
        ShoppingEvent entity = shoppingEventRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Event not found"));

        return convertToDTO(entity); // custom mapping method
    }

    // ...existing code...

    public ShoppingEventDTO createShoppingEvent(ShoppingEventDTO shoppingEventDTO) {
        // Map DTO to Entity
        ShoppingEvent event = new ShoppingEvent();
        event.setShoppingDate(shoppingEventDTO.getShoppingDate());
        event.setDescription(shoppingEventDTO.getDescription());

        SuperMarketDetailsDTO smdDto = shoppingEventDTO.getSuperMarketDetail();

        //fetch supermarket details by ID
        if (smdDto != null && smdDto.getId() != null) {
            //throw new IllegalArgumentException("SuperMarketDetailsDTO or ID cannot be null");
            Optional<SuperMarketDetails> smDetails = superMarketDetailsRepository.findById(smdDto.getId());
            if (smDetails.isPresent()) {
                SuperMarketDetails existingDetails = smDetails.get();
                event.setSuperMarketDetail(existingDetails);
                System.out.println("Using existing SuperMarketDetails: " + existingDetails.getAddress() + ", " + existingDetails.getPhoneNumber());
            } else {
                throw new EntityNotFoundException("SuperMarketDetails not found with ID: " + smdDto.getId());
            }
        } else {
                Optional<SuperMarket> sm = superMarketRepository.findById(1);
                // Map SuperMarketDetailsDTO to SuperMarketDetails entity
                
                SuperMarketDetails superMarketDetails = new SuperMarketDetails();
                //superMarketDetails.setId(smDto.getId());
                superMarketDetails.setAddress(smdDto.getAddress());
                superMarketDetails.setPhoneNumber(smdDto.getPhoneNumber());
                superMarketDetails.setSuperMarket(sm.get());
                System.out.println("SuperMarketDetails: " + superMarketDetails.getAddress() + ", " + superMarketDetails.getPhoneNumber() + ", SuperMarket ID: " + superMarketDetails.getSuperMarket().getId());  
                event.setSuperMarketDetail(superMarketDetails);
        }



        // Save event (cascades if configured)
        ShoppingEvent savedEvent = shoppingEventRepository.save(event);

        return convertToDTO(savedEvent);
    }

    private ShoppingEventDTO convertToDTO(ShoppingEvent event) {
        // Map manually or use a mapper like MapStruct/ModelMapper
        SuperMarketDetailsDTO smDto = new SuperMarketDetailsDTO(
            event.getSuperMarketDetail().getId(),
            event.getSuperMarketDetail().getAddress(),
            event.getSuperMarketDetail().getPhoneNumber()
        );

        List<ShoppingListItemDTO> itemDtos = Optional.ofNullable(event.getShoppingListItems())
    .orElse(List.of()).stream()
            .map(item -> {
                //new ShoppingListItemDTO(item.getId(),item.getItemName(),item.getDescription(),item.getCategory(),item.isPurchased(),item.getQuantity() )
                //return convertToItemDTO(item);
                return shoppingListItemMapper.toDto(item);
            }).collect(Collectors.toList());

        return new ShoppingEventDTO(
            event.getId(),
            event.getShoppingDate(),
            event.getDescription(),
            smDto,
            itemDtos
        );
    }

    private ShoppingListItemDTO convertToItemDTO(ShoppingListItemEntity item) {
        return new ShoppingListItemDTO(
            item.getId(),
            item.getItemName(),
            item.getDescription(),
            item.getCategory(),
            item.isPurchased(),
            item.getQuantity(),
            item.getShoppingEvent() != null ? item.getShoppingEvent().getId() : null
        );
    }
}

