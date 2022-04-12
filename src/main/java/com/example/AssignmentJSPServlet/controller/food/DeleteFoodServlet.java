package com.example.AssignmentJSPServlet.controller.food;

import com.example.AssignmentJSPServlet.entity.Food;
import com.example.AssignmentJSPServlet.model.FoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFoodServlet extends HttpServlet {
    private FoodModel model = new FoodModel();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Food obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else{
            model.delete(id);
            resp.sendRedirect("/foods");
        }
    }
}
