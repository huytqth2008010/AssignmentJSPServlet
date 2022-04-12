package com.example.AssignmentJSPServlet.controller.category;

import com.example.AssignmentJSPServlet.entity.Category;
import com.example.AssignmentJSPServlet.model.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCategoryServlet extends HttpServlet {
    private CategoryModel model = new CategoryModel();

    @Override
    protected void doPost(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else{
            model.delete(id);
            resp.sendRedirect("/categories");
        }
    }
}
