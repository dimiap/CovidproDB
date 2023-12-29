package com.example.covidprodb;

import com.example.covidprodb.models.Admin;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.Calendar;

import static java.lang.System.out;

public class EditProteinDAO {
    public static Integer EditProtein(HttpServletRequest request,String editedProtein) {

        int i = 0;
        out.println(editedProtein);
        Date Date_of_last_modification = new Date(Calendar.getInstance().getTimeInMillis());

        //pairnoume ta stoixeia apo tin forma html
        String entry_name = request.getParameter("Entry_name");
        String statuss = request.getParameter("Statuss");
        String Protein_names = request.getParameter("Protein_names");
        String Gene_names = request.getParameter("Gene_names");
        String Organism = request.getParameter("Organism");
        Integer Length = Integer.valueOf(request.getParameter("Length"));
        String Keyword_ID = request.getParameter("Keyword_ID");
        String Keywords = request.getParameter("Keywords");
        String Annotation = request.getParameter("Annotation");
        String structure_3d = request.getParameter("structure_3d");
        String Beta_strand = request.getParameter("Beta_strand");
        String Helix = request.getParameter("Helix");
        String Turn = request.getParameter("Turn");
        String Topological_domain = request.getParameter("Topological_domain");
        String Subcellular_location = request.getParameter("Subcellular_location");
        String Involvement_in_disease = request.getParameter("Involvement_in_disease");


        Connection conn = null;
        Admin admin = new Admin(null, null);

        PreparedStatement pst = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //sindesi stin vasi
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/COVIDproDB", "root", "1234");

            pst = conn.prepareStatement(admin.EditProtein());

            pst.setString(1, entry_name);
            pst.setString(2, statuss);
            pst.setString(3, Protein_names);
            pst.setString(4, Gene_names);
            pst.setString(5, Organism);
            pst.setInt(6, Length);
            pst.setString(7, Keyword_ID);
            pst.setString(8, Keywords);
            pst.setString(9, Annotation);
            pst.setDate(10, Date_of_last_modification);
            pst.setString(11, structure_3d);
            pst.setString(12, Beta_strand);
            pst.setString(13, Helix);
            pst.setString(14, Turn);
            pst.setString(15, Topological_domain);
            pst.setString(16, Subcellular_location);
            pst.setString(17, Involvement_in_disease);
            pst.setString(18, editedProtein);

            out.println("dao");
            out.println(pst);
            i = pst.executeUpdate();


        } catch (Exception e) {
            out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (i != 0) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }
}
