package com.pahanabookshop.dao;

import com.pahanabookshop.model.Item;
import java.util.List;

public interface ItemDao {
    boolean addItem(Item item);
    Item getItemById(int id);
    List<Item> getAllItems();
    boolean updateItem(Item item);
    boolean deleteItem(int id);
}
