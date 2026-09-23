package com.menuGo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menuGo.entity.MenuItem;
import com.menuGo.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping
    public MenuItem saveMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.saveMenuItem(menuItem);
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItemById(@PathVariable Long id) {
        return menuItemService.getMenuItemById(id);
    }

    @PutMapping("/{id}")
    public MenuItem updateMenuItem(
            @PathVariable Long id,
            @RequestBody MenuItem menuItem) {

        return menuItemService.updateMenuItem(id, menuItem);
    }

    @DeleteMapping("/{id}")
    public String deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return "Menu item deleted successfully";
    }
}