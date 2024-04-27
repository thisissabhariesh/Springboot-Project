package com.example.foodorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodorder.model.Food;
import com.example.foodorder.service.FoodService;

// import com.example.project.model.*;
// import com.example.project.service.*;

@RestController
public class FoodController
{
    @Autowired
    FoodService ps;

    @PostMapping("/api/food")
    public ResponseEntity<Food> adddata(@RequestBody Food p)
    {
        Food obj=ps.create(p);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }
    @GetMapping("/api/food")
    public ResponseEntity<List<Food>> getAll()
    {
        try
        {
            List<Food> f=ps.getAll();
            return new ResponseEntity<>(f,HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/api/food/{foodId}")
    public ResponseEntity<Food> get(@PathVariable("foodId") int foodId )
    {
        try 
        {
        Food p = ps.getById(foodId);
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    catch (Exception e)
    {
            return new ResponseEntity<>(null,HttpStatus.OK);

        }
    }

    @GetMapping("api/sort/{field}")
    public ResponseEntity<List<Food>> getbysort(@PathVariable String field)
    {
        try
        {
            return new ResponseEntity<>(ps.getbysort(field),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/food/{foodId}")
    public ResponseEntity<Food> putMethod(@PathVariable("foodId") int foodId,@RequestBody Food pd)
    {
        if(ps.updateDetails(foodId,pd) == true)
        {
            return new ResponseEntity<>(pd,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/food/{foodId}")
    public ResponseEntity<Boolean> delete(@PathVariable("foodId") int foodId)
    {
        if(ps.deleteFood(foodId) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}