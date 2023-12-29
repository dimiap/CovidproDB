package com.example.covidprodb.controllers;

import com.example.covidprodb.DeleteProteinDAO;
import com.example.covidprodb.EditProteinDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditProteinServlet", value = "/EditProteinServlet")
public class EditProteinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String editedProtein = request.getParameter("Entry");
        System.out.println("servlet");
        System.out.println(request.getParameter("Entry"));
        int edited = EditProteinDAO.EditProtein(request,editedProtein);

        if(edited>0){
            response.sendRedirect("ShowAllServlet");
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("showListOfProteins.jsp");
            out.print("<p style=\"color:red\">Sorry you can't edit this protein </p>");
            rd.include(request, response);
        }
    }
}
