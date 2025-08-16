package com.pahanabookshop.service;

import com.pahanabookshop.model.Item;
import java.util.List;

public interface ItemService {
    boolean addItem(Item item);
    Item getItemById(int id);
    List<Item> getAllItems();
    boolean updateItem(Item item);
    boolean deleteItem(int id);
}
