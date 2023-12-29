package com.example.covidprodb;

import com.example.covidprodb.models.Proteins;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.*;

import static java.lang.System.out;

public class ShowProteinDetailsDAO {
    public static Proteins ShowProteinInfo(String proteinEntry, HttpServletRequest request){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Proteins proteins = new Proteins();
        //credentials gia sindesi stin vasi
        String url = "jdbc:mysql://localhost:3306/COVIDproDB";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        Proteins protein = new Proteins();

        try {
            Class.forName(driver).newInstance();
            //sindesi stin vasi
            conn = DriverManager
                    .getConnection(url, userName, password);

            pst = conn

                    .prepareStatement(proteins.ShowProteinDetails());

            pst.setString(1, proteinEntry);

            //HttpSession session = request.getSession(false);
            //session.getAttribute("username"); //session gia na mporei na ginei edit 'h oxi


            rs = pst.executeQuery();

            if(rs.next()){
                protein.setEntry(rs.getString("Entry"));
                protein.setEntry_name(rs.getString("Entry_name"));
                protein.setStatuss(rs.getString("Statuss"));
                protein.setProtein_names(rs.getString("Protein_names"));
                protein.setGene_names(rs.getString("Gene_names"));
                protein.setOrganism(rs.getString("Organism"));
                protein.setLength(rs.getInt("Length"));
                protein.setKeyword_ID(rs.getString("Keyword_ID"));
                protein.setKeywords(rs.getString("Keywords"));
                protein.setAnnotation(rs.getString("Annotation"));
                protein.setDate_of_creation(rs.getDate("Date_of_creation"));
                protein.setDate_of_last_modification(rs.getDate("Date_of_last_modification"));
                protein.setStructure_3d(rs.getString("structure_3d"));
                protein.setBeta_strand(rs.getString("Beta_strand"));
                protein.setHelix(rs.getString("Helix"));
                protein.setTurn(rs.getString("Turn"));
                protein.setTopological_domain(rs.getString("Topological_domain"));
                protein.setSubcellular_location(rs.getString("Subcellular_location"));
                protein.setInvolvement_in_disease(rs.getString("Involvement_in_disease"));
            }



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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return protein;
    }
}
