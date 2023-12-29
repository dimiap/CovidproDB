package com.example.covidprodb;

import com.example.covidprodb.models.Proteins;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ShowProteinsDAO {
    public static List<Proteins> ShowAllProteins(HttpServletRequest request) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Proteins proteins = new Proteins();
        //credentials gia sindesi stin vasi
        String url = "jdbc:mysql://localhost:3306/COVIDproDB";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        List<Proteins> arrayList = new ArrayList<Proteins>();
        try {
            Class.forName(driver).newInstance();
            //sindesi stin vasi
            conn = DriverManager
                    .getConnection(url, userName, password);

            pst = conn

                    .prepareStatement(proteins.ShowAll());

            HttpSession session = request.getSession(false);
            session.getAttribute("username");


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
