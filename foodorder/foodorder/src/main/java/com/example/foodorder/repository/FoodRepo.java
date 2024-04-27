package com.example.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorder.model.Food;

// import com.example.project.model.Product;

public interface FoodRepo extends JpaRepository<Food,Integer>{
   
}