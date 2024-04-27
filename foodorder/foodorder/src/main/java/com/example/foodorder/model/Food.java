package com.example.foodorder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Food
{
    @Id
    int foodId;
    String foodName;
    String foodDescription;
    int foodCost;
    String foodCuisine;
    String foodHotel;
    String userLocation;
    String number;
    
    public Food()
    {

    }
    
    public Food(int foodId, String foodName, String foodDescription, int foodCost, String foodCuisine, String foodHotel,
            String userLocation, String number) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodCost = foodCost;
        this.foodCuisine = foodCuisine;
        this.foodHotel = foodHotel;
        this.userLocation = userLocation;
        this.number = number;
    }
    public int getFoodId() {
        return foodId;
    }
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getFoodDescription() {
        return foodDescription;
    }
    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }
    public int getFoodCost() {
        return foodCost;
    }
    public void setFoodCost(int foodCost) {
        this.foodCost = foodCost;
    }
    public String getFoodCuisine() {
        return foodCuisine;
    }
    public void setFoodCuisine(String foodCuisine) {
        this.foodCuisine = foodCuisine;
    }
    public String getFoodHotel() {
        return foodHotel;
    }
    public void setFoodHotel(String foodHotel) {
        this.foodHotel = foodHotel;
    }
    public String getUserLocation() {
        return userLocation;
    }
    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

}