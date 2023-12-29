package com.example.covidprodb.controllers;

import com.example.covidprodb.ShowProteinsDAO;
import com.example.covidprodb.models.Proteins;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ShowAllServlet", value = "/ShowAllServlet")
public class  ShowAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Proteins> entryList = ShowProteinsDAO.ShowAllProteins(request);
        request.setAttribute("entryListBeta",entryList.stream().filter(b->b.getBeta_strand().length()>0).collect(Collectors.toList()));
        request.setAttribute("entryListHelix",entryList.stream().filter(h->h.getHelix().length()>0).collect(Collectors.toList()));
        request.setAttribute("entryListTurn",entryList.stream().filter(t->t.getTurn().length()>0).collect(Collectors.toList()));
        request.setAttribute("entryListUndefined",entryList.stream().filter(b->b.getBeta_strand().isEmpty())
                .filter(h->h.getHelix().isEmpty()).filter(t->t.getTurn().isEmpty()).collect(Collectors.toList()));
        RequestDispatcher rd = request.getRequestDispatcher("/showListOfProteins.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
