package com.example.covidprodb;

import com.example.covidprodb.models.Proteins;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class AdvancedSearchDAO {
    public static List<Proteins> AdvancedSearch(String searchTerm,String entry_name,String organism,String structure_3d, String logic_gate1, String logic_gate2, String logic_gate3,String notOrNo1, String notOrNo2,String notOrNo3, HttpServletRequest request) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Proteins proteins = new Proteins();
        String AdvancedSearch;
        int par_ind = 1;
        //credentials gia sindesi stin vasi
        String url = "jdbc:mysql://localhost:3306/COVIDproDB";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        List<Proteins> arrayList = new ArrayList();
        try {
            Class.forName(driver).newInstance();
            //sindesi stin vasi
            conn = DriverManager
                    .getConnection(url, userName, password);

            AdvancedSearch = proteins.Search();
            if(!(logic_gate1 ==null|| logic_gate1.equals("Select Logic Gate For Entry Name"))){
                if(notOrNo1.equals("")){
                    AdvancedSearch = AdvancedSearch +logic_gate1 +" general_info.entry_name LIKE ?";
                }
                else{
                    AdvancedSearch = AdvancedSearch +logic_gate1 +" general_info.entry_name NOT LIKE ?";
                }
            }
            if(!(logic_gate2 ==null|| logic_gate2.equals("Select Logic Gate For Organism"))){
                if(notOrNo2.equals("")){
                    AdvancedSearch = AdvancedSearch +logic_gate2 + " general_info.organism LIKE ?";
                }
                else{
                    AdvancedSearch = AdvancedSearch +logic_gate1 +" general_info.organism NOT LIKE ?";
                }
            }
            if(!(logic_gate3 ==null|| logic_gate3.equals("Select Logic Gate For 3D Structure"))){
                if(notOrNo3.equals("")){
                    AdvancedSearch = AdvancedSearch+logic_gate3+" structure_location.structure_3d LIKE ?";
                }
                else{
                    AdvancedSearch = AdvancedSearch+logic_gate3+" structure_location.structure_3d ΝΟΤ LIKE ?";
                }
            }
            pst = conn

                    .prepareStatement(AdvancedSearch);


            pst.setString(par_ind, "%" + searchTerm + "%");
            pst.setString(++par_ind, "%" + searchTerm + "%");
            if(!(logic_gate1 ==null|| logic_gate1.equals("Select Logic Gate For Entry Name"))) {
                pst.setString(++par_ind, "%" + entry_name + "%");
            }
            if(!(logic_gate2 ==null|| logic_gate2.equals("Select Logic Gate For Organism"))){
                pst.setString(++par_ind, "%" + organism + "%");
            }
            if(!(logic_gate3 ==null|| logic_gate3.equals("Select Logic Gate For 3D Structure"))){
                pst.setString(++par_ind, "%" + structure_3d + "%");
            }

            HttpSession session = request.getSession(false);
            session.getAttribute("username");

            out.println(pst);
            rs = pst.executeQuery();

            while (rs.next()) {
                Proteins protein = new Proteins();
                protein.entry = rs.getString("Entry");
                protein.beta_strand = rs.getString("beta_strand");
                protein.helix = rs.getString("helix");
                protein.turn = rs.getString("turn");
                arrayList.add(protein);
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
        return arrayList;
    }
}
