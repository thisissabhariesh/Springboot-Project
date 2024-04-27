package com.example.foodorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.foodorder.model.Food;
import com.example.foodorder.repository.FoodRepo;

// import com.example.project.model.*;
// import com.example.project.repository.*;

@Service
public class FoodService {
   
    @Autowired
    FoodRepo pr;

    //post
    public Food create(Food p)
    {
       
        return pr.save(p);
    }
    public List<Food> getAll()
    {
        return pr.findAll();
    }

    //getbyid
    public Food getById(int foodId)
    {
        return pr.findById(foodId).orElse(null);
    }
    //put
    public boolean updateDetails(int foodId,Food p)
    {
        if(pr.findById(foodId)==null)
        {
            return false;
        }
        try
        {
            pr.save(p);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean deleteFood(int foodId)
    {
        if(this.getById(foodId) == null)
        {
            return false;
        }
        pr.deleteById(foodId);
        return true;
    }

    public List<Food> getbysort(String field)
    {
        return pr.findAll(Sort.by(Sort.Direction.ASC,field));
    }

}