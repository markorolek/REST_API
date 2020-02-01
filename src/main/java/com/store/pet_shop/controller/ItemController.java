package com.store.pet_shop.controller;

import com.store.pet_shop.model.Item;
import com.store.pet_shop.repository.ItemRepository;
import com.store.pet_shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(value = "/items")
    public @ResponseBody Iterable<Item> getItems(){
        return itemRepository.findAll();
    }

    @PostMapping(value = "/add/item")
    public @ResponseBody Item create(@RequestBody Item item){
        return itemRepository.save(item);
    }


    /*private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<Item>> getItems(){
        final List<Item> items = itemService.getAllItems();

        return items != null &&  !items.isEmpty()
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/items/{id}")
    public ResponseEntity<Item> getItem(@PathVariable(name = "id") int id){
        final Item item = itemService.getItemById(id);

        return item != null
                ? new ResponseEntity<>(item, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/items/sort/{type}")
    public ResponseEntity<List<Item>> getByType(@PathVariable(name = "type") String type){
        final List<Item> items = itemService.getItemsByType(type);

        return items != null &&  !items.isEmpty()
                ? new ResponseEntity<>(items, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/add/item")
    public ResponseEntity<?> create(@RequestBody Item item){
        itemService.createItem(item);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/add/items")
    public ResponseEntity<?> createAll(@RequestBody Item[] items){
        itemService.createItems(items);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/items/{id}")
    public ResponseEntity<?> change(@RequestBody Item item, @PathVariable(name = "id") int id){
        final boolean temp = itemService.changeItem(item, id);

        return temp
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/items/{id}")
    public ResponseEntity<?> delById(@PathVariable(name = "id") int id){
        final boolean temp = itemService.deleteItemById(id);

        return temp
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/items")
    public ResponseEntity<?> delAll(){
        itemService.deleteAllItems();
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
