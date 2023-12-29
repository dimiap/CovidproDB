package com.example.covidprodb.controllers;

import com.example.covidprodb.AdminDAO;
import com.example.covidprodb.models.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private Admin admin = new Admin(null,null);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //pairnei apo to request tis times tou username kai pass
        admin.username = request.getParameter("username");
        admin.pass = request.getParameter("pass");


        HttpSession session = request.getSession(false);
        if (session != null) {
            //dimiourgei session me to username gia na meinei kai stin epomeni selida
            session.setAttribute("username", admin.username);
        }
        if (AdminDAO.LoginAdmin(admin.username, admin.pass)) {
            doGet(null, null);
            //an exei parei tis times pernaei to request kai response stin selida welcomeAdmin
            response.sendRedirect("ShowAllServlet");
        } else {
            //an den uparxei o xristis vgazei stin arxiki oti den yparxei o kodikos kai to password
            out.print("<p style=\"color:red\">Sorry username or password error</p>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        }
        out.close();
    }
}
