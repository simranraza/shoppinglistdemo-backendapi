package com.genius.shoppingListDemo.mappers;

import com.genius.shoppingListDemo.entity.ShoppingEvent;
import com.genius.shoppingListDemo.entity.ShoppingListItemEntity;
import com.genius.shoppingListDemo.query.dto.ShoppingListViewDTO;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingListViewMapper {

    @Named("toShoppingListViewDTOlist")
    @IterableMapping(qualifiedByName = "toShoppingListViewDTOlist")
    default List<ShoppingListViewDTO> toShoppingListViewDTOList(List<ShoppingEvent> shoppingEvents) {
        List<ShoppingListViewDTO> result = new ArrayList<>();
        for (ShoppingEvent event : shoppingEvents) {
            if (event.getShoppingListItems() != null) {
                for (ShoppingListItemEntity item : event.getShoppingListItems()) {
                    result.add(toShoppingListViewDTO(event, item));
                }
            }
        }
        return result;
    }

    @Named("toShoppingListViewDTO")
    @Mapping(source = "item.itemName", target = "itemName")
    @Mapping(source = "item.description", target = "description")
    @Mapping(source = "item.category", target = "category")
    @Mapping(source = "item.quantity", target = "quantity")
    @Mapping(source = "event.shoppingDate", target = "shoppingDate")
    @Mapping(source = "event.superMarketDetail.superMarket.name", target = "superMarketName")
    @Mapping(source = "event.superMarketDetail.address", target = "superMarketAddress")
    ShoppingListViewDTO toShoppingListViewDTO(ShoppingEvent event, ShoppingListItemEntity item);
}
