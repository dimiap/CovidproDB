package com.example.covidprodb;

import com.example.covidprodb.models.Admin;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Calendar;

public class CreateProteinDAO {
    public static Integer CreateProtein(HttpServletRequest request) throws SQLException {
        int i = 0, rs1, rs2, rs3;

        Date Date_of_creation = new Date(Calendar.getInstance().getTimeInMillis()); //otan ftiaxnoume nea eggrafi h hmera dimiourgias
        Date Date_of_last_modification = Date_of_creation;  // kai h imera tropopoihshs einai h shmerini imerominia

        //pairnoume ta stoixeia apo tin forma html
        String Entry = request.getParameter("Entry");
        String Entry_name = request.getParameter("Entry_name");
        String Statuss = request.getParameter("Statuss");
        String Protein_names = request.getParameter("Protein_names");
        String Gene_names = request.getParameter("Gene_names");
        String Organism = request.getParameter("Organism");
        int Length = Integer.parseInt(request.getParameter("Length"));
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

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/COVIDproDB", "root", "1234");
            //arxizoume to transaction gia na kanoume pollapla insertions
            conn.setAutoCommit(false);

            PreparedStatement pst = conn.prepareStatement(admin.CreateProteinTableGeneral_Info());

            pst.setString(1, Entry);
            pst.setString(2, Entry_name);
            pst.setString(3, Statuss);
            pst.setString(4, Protein_names);
            pst.setString(5, Gene_names);
            pst.setString(6, Organism);
            pst.setInt(7, Length);

            rs1 = pst.executeUpdate();
            //an mporesei na kanei to proto insert na kanei kai to deutero
            if (rs1 > 0) {
                pst = conn.prepareStatement(admin.CreateProteinTableAnnotation());

                pst.setString(1, Entry);
                pst.setString(2, Keyword_ID);
                pst.setString(3, Keywords);
                pst.setString(4, Annotation);

                rs2 = pst.executeUpdate();

                //an mporesei na kanei to proto kai deutero insert na kanei kai to trito
                if (rs2 > 0) {
                    pst = conn.prepareStatement(admin.CreateProteinTableStructure_Location());

                    pst.setString(1, Entry);
                    pst.setDate(2, Date_of_creation);
                    pst.setDate(3, Date_of_last_modification);
                    pst.setString(4, structure_3d);
                    pst.setString(5, Beta_strand);
                    pst.setString(6, Helix);
                    pst.setString(7, Turn);
                    pst.setString(8, Topological_domain);
                    pst.setString(9, Subcellular_location);
                    pst.setString(10, Involvement_in_disease);

                    rs3 = pst.executeUpdate();
                    pst.close();
                    //kleinei to transaction
                    conn.commit();
                    i = rs1 + rs2 + rs3;
                }
            }
        } catch (Exception e2) {
            System.out.println(e2);
            assert conn != null;
            //se periptosi provlimatos me to transaction kanei rollback
            conn.rollback();
        }
        return i;
    }
}
