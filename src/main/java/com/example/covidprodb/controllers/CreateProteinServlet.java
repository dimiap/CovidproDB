package com.example.covidprodb.controllers;

import com.example.covidprodb.CreateProteinDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "CreateProteinServlet", value = "/CreateProteinServlet")
public class CreateProteinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int i = 0;
        try {
            i = CreateProteinDAO.CreateProtein(request);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(i>0){
            out.print("<p style=\"color:red\">Successful!</p>");
            response.sendRedirect("ShowAllServlet");
        }
    }
}
