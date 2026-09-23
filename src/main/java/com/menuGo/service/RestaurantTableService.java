package com.menuGo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuGo.entity.RestaurantTable;
import com.menuGo.repository.RestaurantTableRepository;

@Service
public class RestaurantTableService {

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    public RestaurantTable saveRestaurantTable(RestaurantTable restaurantTable) {
        return restaurantTableRepository.save(restaurantTable);
    }

    public List<RestaurantTable> getAllRestaurantTables() {
        return restaurantTableRepository.findAll();
    }

    public RestaurantTable getRestaurantTableById(Long id) {
        return restaurantTableRepository.findById(id).orElse(null);
    }

    public RestaurantTable updateRestaurantTable(
            Long id, RestaurantTable restaurantTable) {

        RestaurantTable existingTable =
                restaurantTableRepository.findById(id).orElse(null);

        if (existingTable == null) {
            return null;
        }

        existingTable.setRestaurantId(restaurantTable.getRestaurantId());
        existingTable.setTableNumber(restaurantTable.getTableNumber());
        existingTable.setStatus(restaurantTable.getStatus());
        existingTable.setQrToken(restaurantTable.getQrToken());
        existingTable.setQrImagePath(restaurantTable.getQrImagePath());

        return restaurantTableRepository.save(existingTable);
    }

    public void deleteRestaurantTable(Long id) {
        restaurantTableRepository.deleteById(id);
    }
}