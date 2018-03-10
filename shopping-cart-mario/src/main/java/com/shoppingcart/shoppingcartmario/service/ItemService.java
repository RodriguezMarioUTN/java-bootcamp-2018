package com.shoppingcart.shoppingcartmario.service;

import com.shoppingcart.shoppingcartmario.dto.ItemDTO;
import com.shoppingcart.shoppingcartmario.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItem(Integer idItem);
    Item createItem(ItemDTO itemDTO);
    void updateItem(Item item);
    void deleteItem(Integer idItem);
}
