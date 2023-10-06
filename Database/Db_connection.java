/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jaisika
 */
public  class Db_connection {
  static Connection con;
    public static  Connection getConnection() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", ".........");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
}

