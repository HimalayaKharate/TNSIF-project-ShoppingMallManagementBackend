package org.himluck.shoppingmall.mall.service;

import org.himluck.shoppingmall.mall.entities.Item;
import org.himluck.shoppingmall.mall.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Add a new item
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get item by ID
    public Optional<Item> getItemById(int id) {
        return itemRepository.findById(id);
    }

    // Update an existing item
    public Item updateItem(int id, Item newItem) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setManufactureDate(newItem.getManufactureDate());
                    item.setExpiringDate(newItem.getExpiringDate());
                    item.setTotal(newItem.getTotal());
                    item.setCategories(newItem.getCategories());
                    return itemRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    // Delete an item by ID
    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
