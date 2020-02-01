package com.store.pet_shop.service;

import com.store.pet_shop.model.Item;

import java.util.List;

public interface ItemService {

    /**
     * Возвращает список всех товаров
     * @return список товаров
     */
    List<Item> getAllItems();

    /**
     * Возвращает товар по заданному id
     * @param id - ID клиента
     * @return товар по id
     */
    Item getItemById(int id);

    /**
     * Волзвращает товар/товары по определенному типу
     * @param type - тип товара
     * @return список всех итемов по данному типу
     */
    List<Item> getItemsByType(String type);

    /**
     * Создает новый товаров
     * @param item - товар для создания
     */
    void createItem(Item item);

    /**
     * Создаёт массив товаров
     * @param items - массив итемов для создания
     */
    void createItems(Item[] items);

    /**
     * Обновляет товар с заданным id,
     * в соответствии с переданным товаром
     * @param item - товар в соответсвии с которым нужно обновить данные
     * @param id - id товара который обновляется
     * @return - true если данные были обновлены, иначе false
     */

    boolean changeItem(Item item, int id);

    /**
     * Удаляет товар с заданным id
     * @param id - id товара, который нужно удалить
     * @return - true если товар был удален, иначе false
     */
    boolean deleteItemById(int id);

    /**
     * Удаляет все товары
     */
    void deleteAllItems();
}
