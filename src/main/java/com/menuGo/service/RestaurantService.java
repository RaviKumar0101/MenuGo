package com.menuGo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menuGo.entity.Restaurant;
import com.menuGo.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
	
    
    public Restaurant saveRestaurant(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }
    
    
    
    public List<Restaurant> getAllRestaurants() {

        return restaurantRepository.findAll();
    }
    
    
    
    public Restaurant getRestaurantById(Long id) {

        return restaurantRepository.findById(id).orElse(null);
    }
    
    
    
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {

        Restaurant existingRestaurant = restaurantRepository.findById(id).orElse(null);

        if (existingRestaurant == null) {
            return null;
        }

        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setAddress(restaurant.getAddress());
        existingRestaurant.setPhone(restaurant.getPhone());
        existingRestaurant.setEmail(restaurant.getEmail());
        existingRestaurant.setLogo(restaurant.getLogo());
        existingRestaurant.setDescription(restaurant.getDescription());
        existingRestaurant.setOpeningTime(restaurant.getOpeningTime());
        existingRestaurant.setClosingTime(restaurant.getClosingTime());
        existingRestaurant.setPlatformStatus(restaurant.getPlatformStatus());
        existingRestaurant.setOperationalStatus(restaurant.getOperationalStatus());

        return restaurantRepository.save(existingRestaurant);
    }
    
    
    
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
    
    
    
}
