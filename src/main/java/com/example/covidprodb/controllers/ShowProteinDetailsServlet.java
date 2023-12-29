package com.example.covidprodb.controllers;

import com.example.covidprodb.ShowProteinDetailsDAO;
import com.example.covidprodb.models.Proteins;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "ShowProteinDetailsServlet", value = "/ShowProteinDetailsServlet")
public class ShowProteinDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String entry = request.getParameter("entry");
        String formOfOrigin = request.getParameter("formOfOrigin");
        Proteins protein = ShowProteinDetailsDAO.ShowProteinInfo(entry,request);
        request.setAttribute("Proteins",protein);
        HttpSession session = request.getSession();
        session.setAttribute("formOfOrigin", formOfOrigin);
        request.getRequestDispatcher("proteinInfo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
