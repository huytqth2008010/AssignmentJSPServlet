package com.example.AssignmentJSPServlet.controller.category;

import com.example.AssignmentJSPServlet.entity.Category;
import com.example.AssignmentJSPServlet.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/category/create_category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        Integer status = Integer.parseInt(req.getParameter("status"));
        Category obj = new Category(categoryName, status);
        CategoryModel model = new CategoryModel();
        model.save(obj);
        resp.sendRedirect("/categories");

    }
}
