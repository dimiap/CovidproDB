package com.example.covidprodb.controllers;

import com.example.covidprodb.AdvancedSearchDAO;
import com.example.covidprodb.models.Proteins;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "AdvancedSearchServlet", value = "/AdvancedSearchServlet")
public class AdvancedSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm=request.getParameter("searchTerm");
        String entry_name = request.getParameter("entry_name");
        String organism = request.getParameter("organism");
        String structure_3d = request.getParameter("structure_3d");
        String logic_gates1 = request.getParameter("logicGates1");
        String logic_gates2 = request.getParameter("logicGates2");
        String logic_gates3 = request.getParameter("logicGates3");
        String notOrNo1 = request.getParameter("notOrNo1");
        String notOrNo2 = request.getParameter("notOrNo2");
        String notOrNo3 = request.getParameter("notOrNo3");

        List<Proteins> entryList = AdvancedSearchDAO.AdvancedSearch(searchTerm,entry_name,organism,structure_3d,logic_gates1,logic_gates2,logic_gates3,notOrNo1,notOrNo2,notOrNo3,request);
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
