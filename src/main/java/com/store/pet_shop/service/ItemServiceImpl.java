package com.store.pet_shop.service;

import com.store.pet_shop.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ItemServiceImpl implements ItemService{

    //Хранилище итемов
    private static final Map<Integer, Item> ITEMS_MAP = new HashMap<>();

    // Переменная для генерации id товара
    private static final AtomicInteger ITEM_ID_HOLDER = new AtomicInteger();

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(ITEMS_MAP.values());
    }

    @Override
    public Item getItemById(int id) {
        return ITEMS_MAP.get(id);
    }

    @Override
    public List<Item> getItemsByType(String type){
        List<Item> list = new ArrayList<>();
        for (Item item : ITEMS_MAP.values()) {
            if (item.getType().equals(type))
                list.add(item);
        }
        return list;
    }

    @Override
    public void createItem(Item item) {
        final int itemId = ITEM_ID_HOLDER.incrementAndGet();
        item.setId(itemId);
        ITEMS_MAP.put(itemId, item);
    }

    @Override
    public void createItems(Item[] items){
        for (int i = 0; i < items.length; i++) {
            int itemId = ITEM_ID_HOLDER.incrementAndGet();
            items[i].setId(itemId);
            ITEMS_MAP.put(itemId, items[i]);
        }
    }

    @Override
    public boolean changeItem(Item item, int id) {
        if(ITEMS_MAP.containsKey(id)){
            item.setId(id);
            ITEMS_MAP.put(id, item);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean deleteItemById(int id) {
        if (ITEMS_MAP.containsKey(id)){
            ITEMS_MAP.remove(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void deleteAllItems() {
        ITEMS_MAP.clear();
    }
}
