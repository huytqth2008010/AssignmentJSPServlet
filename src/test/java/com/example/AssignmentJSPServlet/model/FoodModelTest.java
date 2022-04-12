package com.example.AssignmentJSPServlet.model;

import com.example.AssignmentJSPServlet.entity.Food;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodModelTest {

    @Test
    void save() {
        FoodModel model = new FoodModel();
        model.save(new Food("Huy", 1, "a", "a", 11, 1));
    }

    @Test
    void testSave() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        FoodModel model = new FoodModel();
        Food food = model.findById(10);
        System.out.println(food.toString());
    }

    @Test
    void update() {
        FoodModel model = new FoodModel();
        Food food = model.findById(10);
        System.out.println(food.toString());
        food.setName("Huy 88");
        model.update(10,food);
    }

    @Test
    void delete() {
        FoodModel model = new FoodModel();
        model.delete(1);
    }

    @Test
    void testSave1() {
        FoodModel model = new FoodModel();
        model.save(new Food("Huy", 1, "a", "https://upload.wikimedia.org/wikipedia/commons/c/c3/Yen_Bai_-_dogs_-_P1390010.JPG", 11, 1));
    }
}