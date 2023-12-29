package com.example.covidprodb;

import com.example.covidprodb.models.Admin;
import com.example.covidprodb.models.Proteins;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class DeleteProteinDAO {
    public static Integer DeleteProtein(String deletedProtein) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        Integer rs = 0;
        Admin admin = new Admin(null,null);
        //credentials gia sindesi stin vasi
        String url = "jdbc:mysql://localhost:3306/COVIDproDB";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        try {
            Class.forName(driver).newInstance();
            //sindesi stin vasi
            conn = DriverManager
                    .getConnection(url, userName, password);

            pst = conn

                    .prepareStatement(admin.DeleteProtein());

            pst.setString(1, deletedProtein);


            rs = pst.executeUpdate();


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
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return rs;
    }
}
