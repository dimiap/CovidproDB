package com.example.covidprodb;

import com.example.covidprodb.models.Admin;

import java.sql.*;

public class AdminDAO {
    //sindesi tou admin stin vasi
    public static boolean LoginAdmin(String username, String pass) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
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
                    .getConnection(url,userName, password);

            pst = conn

                    .prepareStatement(admin.LoginAdmin());
            //pernaei ta values pou xreiazetai gia na doulepsei to query
            pst.setString(1, username);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
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
        return status;
    }
}
