package com.pahanabookshop.service.impl;

import com.pahanabookshop.dao.ItemDao;
import com.pahanabookshop.dao.impl.ItemDaoImpl;
import com.pahanabookshop.model.Item;
import com.pahanabookshop.service.ItemService;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao = new ItemDaoImpl();

    @Override
    public boolean addItem(Item item) {
        return itemDao.addItem(item);
    }

    @Override
    public Item getItemById(int id) {
        return itemDao.getItemById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    @Override
    public boolean updateItem(Item item) {
        return itemDao.updateItem(item);
    }

    @Override
    public boolean deleteItem(int id) {
        return itemDao.deleteItem(id);
    }
}
