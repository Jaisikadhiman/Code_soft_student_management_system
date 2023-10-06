/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Getter_setter.AddStu;

import java.sql.*;

/**
 *
 * @author india
 */
public class Db_operations {

    public static boolean add_details(AddStu ads) {
        boolean status = false;
        try {
            Connection con = Db_connection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, ads.getName());
            ps.setString(2, ads.getEmail());
            ps.setString(3, ads.getAddress());
            ps.setString(4, ads.getPhone());
            ps.setString(5, ads.getCourse());
            ps.setString(6, ads.getFname());
            ps.setString(7, ads.getBranch());
            ps.setString(8, ads.getUniversity());
            ps.setString(9, ads.getGender());
            ps.setString(10, ads.getSem());

            int i = ps.executeUpdate();
            System.out.println("i" + i);
            if (i > 0) {
                status = true;
            } else {
                status = false;
            }

        } catch (Exception e) {
        }
        return status;
    }

    public static ResultSet showAllStu() {
        ResultSet rs = null;
        try {
            Connection con = Db_connection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student");
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    public static ResultSet showDetails(String email) {
        ResultSet rs = null;
        try {
            Connection con = Db_connection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student where email=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    public static int update_details(AddStu ads) {
        int i = 0;
        try {
            Connection con = Db_connection.getConnection();
            PreparedStatement ps = con.prepareStatement("update student set name=?,address=?,phone=?,course=?,fname=?,branch=?,university=?,gender=?,sem=? where email=?");
            ps.setString(1, ads.getName());
            ps.setString(2, ads.getAddress());
            ps.setString(3, ads.getPhone());
            ps.setString(4, ads.getCourse());
            ps.setString(5, ads.getFname());
            ps.setString(6, ads.getBranch());
            ps.setString(7, ads.getUniversity());
            ps.setString(8, ads.getGender());
            ps.setString(9, ads.getSem());
            ps.setString(10, ads.getEmail());
             i=ps.executeUpdate();
        } catch (Exception e) {
              System.out.println(e);
        }
        return i;
    }
    
    public static int delete_details(String email){
        int i=0;
        try {
          Connection con=Db_connection.getConnection();
          PreparedStatement ps =con.prepareStatement("delete from student where email=?");
          ps.setString(1, email);
           i=ps.executeUpdate();
        } catch (Exception e) {
        }
        return i;
    }
}
