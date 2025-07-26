package com.genius.shoppingListDemo.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.genius.shoppingListDemo.dto.ShoppingListItemDTO;
import com.genius.shoppingListDemo.entity.ShoppingEvent;
import com.genius.shoppingListDemo.entity.ShoppingListItemEntity;

@Mapper(componentModel = "spring")
public interface ShoppingListItemMapper {
    ShoppingListItemMapper INSTANCE = Mappers.getMapper(ShoppingListItemMapper.class);

    // Define mapping methods here
    // For example:
    // ShoppingListItemDTO toDto(ShoppingListItemEntity entity);
    // ShoppingListItemEntity toEntity(ShoppingListItemDTO dto);
    
    @Mappings({
        @Mapping(source = "itemName", target = "name"),
        @Mapping(source = "shoppingEvent.id", target = "shoppingEventId")
    })
    ShoppingListItemDTO toDto(ShoppingListItemEntity entity);

    @Mappings({
        @Mapping(source = "name", target = "itemName"),
        @Mapping(target = "shoppingEvent", ignore = true)
    })
    ShoppingListItemEntity toEntity(ShoppingListItemDTO dto);

    // Optional if using update mappings
    @AfterMapping
    default void linkShoppingEvent(@MappingTarget ShoppingListItemEntity entity, ShoppingListItemDTO dto) {
        if (dto.getShoppingEventId() != null) {
            ShoppingEvent event = new ShoppingEvent();
            event.setId(dto.getShoppingEventId());
            entity.setShoppingEvent(event);
        }
    }

}
