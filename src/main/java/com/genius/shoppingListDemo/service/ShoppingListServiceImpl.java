package com.genius.shoppingListDemo.service;

import com.genius.shoppingListDemo.dto.ShoppingListItemDTO;
import com.genius.shoppingListDemo.entity.ShoppingListItemEntity;
import com.genius.shoppingListDemo.mappers.ShoppingListItemMapper;
import com.genius.shoppingListDemo.repository.ShoppingListRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingListServiceImpl implements ShoppingListService{

    private final Logger logger = LoggerFactory.getLogger(ShoppingListServiceImpl.class);

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ShoppingListItemMapper shoppingListItemMapper;

    @Override
    public List<ShoppingListItemDTO> findAll() {
        List<ShoppingListItemDTO> shoppingListItemDtoList = new ArrayList<>();

        TypeMap<ShoppingListItemEntity, ShoppingListItemDTO> propertyMapper = this.modelMapper.createTypeMap(ShoppingListItemEntity.class, ShoppingListItemDTO.class);
        propertyMapper.addMapping(ShoppingListItemEntity::getId, ShoppingListItemDTO::setId);
        propertyMapper.addMapping(ShoppingListItemEntity::getItemName, ShoppingListItemDTO::setName);
        List<ShoppingListItemEntity> shoppingListItemEntityList = shoppingListRepository.findAll();

        //TODO: if shoppingListItemEntityList is empty then throw error
        shoppingListItemEntityList.forEach(shoppingListItemEntity -> {
            ShoppingListItemDTO shoppingListItemDto = new ShoppingListItemDTO();
            modelMapper.map(shoppingListItemEntity, shoppingListItemDto);
            shoppingListItemDtoList.add(shoppingListItemDto);
        });
        return shoppingListItemDtoList;
    }

    @Override
    public List<ShoppingListItemDTO> saveOrUpdateItems(List<ShoppingListItemDTO> itemDTOs) {
        
        // Convert DTOs to Entities
        List<ShoppingListItemEntity> shoppingListItemEntities = new ArrayList<>();
        itemDTOs.forEach(itemDTO -> {
            ShoppingListItemEntity entity = shoppingListItemMapper.toEntity(itemDTO);
            shoppingListItemEntities.add(entity);
        });
        // Save or update entities in the repository
        List<ShoppingListItemEntity> savedEntities = shoppingListRepository.saveAll(shoppingListItemEntities);
        // Convert saved entities back to DTOs
        
        List<ShoppingListItemDTO> savedItemDTOs = Optional.ofNullable(savedEntities).orElse(List.of()).stream().map(savedEntity -> {
            ShoppingListItemDTO dto = shoppingListItemMapper.toDto(savedEntity);
           
            return dto;
        }).collect(Collectors.toList());
        
        return savedItemDTOs;
    }

    @Override
    public List<ShoppingListItemDTO> findItemsByEventId(Integer shoppingEventId) {
        List<ShoppingListItemEntity> shoppingListItemEntities = shoppingListRepository.findByShoppingEventId(shoppingEventId);
        
        if (shoppingListItemEntities.isEmpty()) {
            logger.warn("No items found for shopping event ID: {}", shoppingEventId);
            return List.of(); // Return an empty list if no items found
        }
        
        // Convert entities to DTOs
        return shoppingListItemEntities.stream()
                .map(shoppingListItemMapper::toDto)
                .collect(Collectors.toList());
    }
}
