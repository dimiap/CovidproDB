package com.example.covidprodb.controllers;

import com.example.covidprodb.AdminDAO;
import com.example.covidprodb.DeleteProteinDAO;
import com.example.covidprodb.models.Proteins;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteProteinServlet", value = "/DeleteProteinServlet")
public class DeleteProteinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String entry = request.getParameter("entry");
        int cntDeleted = DeleteProteinDAO.DeleteProtein(entry);

        if (cntDeleted > 0) {
            //an exei kanei delete kapoia eggrafi tote ksanafortonei tin selida me oles tis proteines
            response.sendRedirect("ShowAllServlet");
        } else {
            //an den uparxei h proteini pou prospathei na diagrapsei o xristis (se periptosi error)
            RequestDispatcher rd = request.getRequestDispatcher("showListOfProteins.jsp");
            out.print("<p style=\"color:red\">Sorry you can't delete this protein </p>");
            rd.include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
