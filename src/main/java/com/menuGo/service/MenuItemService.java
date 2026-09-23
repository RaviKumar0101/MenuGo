package com.menuGo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuGo.entity.MenuItem;
import com.menuGo.repository.MenuItemRepository;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    public MenuItem updateMenuItem(Long id, MenuItem menuItem) {

        MenuItem existingMenuItem = menuItemRepository.findById(id).orElse(null);

        if (existingMenuItem == null) {
            return null;
        }

        existingMenuItem.setCategoryId(menuItem.getCategoryId());
        existingMenuItem.setName(menuItem.getName());
        existingMenuItem.setDescription(menuItem.getDescription());
        existingMenuItem.setPrice(menuItem.getPrice());
        existingMenuItem.setImage(menuItem.getImage());
        existingMenuItem.setFoodType(menuItem.getFoodType());
        existingMenuItem.setAvailability(menuItem.getAvailability());

        return menuItemRepository.save(existingMenuItem);
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}