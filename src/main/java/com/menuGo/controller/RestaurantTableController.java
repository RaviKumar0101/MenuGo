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

import com.menuGo.entity.RestaurantTable;
import com.menuGo.service.RestaurantTableService;

@RestController
@RequestMapping("/restaurant-tables")
public class RestaurantTableController {

    @Autowired
    private RestaurantTableService restaurantTableService;

    @PostMapping
    public RestaurantTable saveRestaurantTable(
            @RequestBody RestaurantTable restaurantTable) {

        return restaurantTableService.saveRestaurantTable(restaurantTable);
    }

    @GetMapping
    public List<RestaurantTable> getAllRestaurantTables() {
        return restaurantTableService.getAllRestaurantTables();
    }

    @GetMapping("/{id}")
    public RestaurantTable getRestaurantTableById(@PathVariable Long id) {
        return restaurantTableService.getRestaurantTableById(id);
    }

    @PutMapping("/{id}")
    public RestaurantTable updateRestaurantTable(
            @PathVariable Long id,
            @RequestBody RestaurantTable restaurantTable) {

        return restaurantTableService.updateRestaurantTable(id, restaurantTable);
    }

    @DeleteMapping("/{id}")
    public String deleteRestaurantTable(@PathVariable Long id) {

        restaurantTableService.deleteRestaurantTable(id);

        return "Restaurant table deleted successfully";
    }
}