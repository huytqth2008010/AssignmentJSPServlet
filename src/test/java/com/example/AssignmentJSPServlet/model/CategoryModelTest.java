package com.example.AssignmentJSPServlet.model;

import com.example.AssignmentJSPServlet.entity.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryModelTest {

    @Test
    void update() {
        CategoryModel model = new CategoryModel();
        Category category = model.findById(2);
        System.out.println(category.toString());
        category.setCategoryName("Huy");
        model.update(2,category);
    }

    @Test
    void delete() {
        CategoryModel model = new CategoryModel();
        model.delete(2);
    }
}