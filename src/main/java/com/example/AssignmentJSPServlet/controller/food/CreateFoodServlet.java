package com.example.AssignmentJSPServlet.controller.food;

import com.example.AssignmentJSPServlet.entity.Category;
import com.example.AssignmentJSPServlet.entity.Food;
import com.example.AssignmentJSPServlet.model.CategoryModel;
import com.example.AssignmentJSPServlet.model.FoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateFoodServlet extends HttpServlet {
    CategoryModel model = new CategoryModel();
    List<Category> listCategory = model.findAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listCategory", listCategory);
        req.getRequestDispatcher("/admin/food/create_food.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String description = req.getParameter("description");
        String thumbnail = req.getParameter("thumbnail");
        double price = Double.parseDouble(req.getParameter("price"));
        int status = Integer.parseInt(req.getParameter("status"));
        Food obj = new Food(name, categoryId, description, thumbnail, price, status);
        if(!obj.isValid()){
            req.setAttribute("errors", obj.getErrors());
            req.getRequestDispatcher("/admin/food/create_food.jsp").forward(req, resp);
        }else{
            FoodModel model = new FoodModel();
            model.save(obj);
            resp.sendRedirect("/foods");
        }
    }
}
