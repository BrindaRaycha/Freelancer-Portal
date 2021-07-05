/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Entity.CityTB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author brinda
 */
@Named(value = "combo")
@ApplicationScoped
public class comboBean {
     public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Freelancer_Portal", "root", "brinda");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return con;
    }
    
    @ApplicationScoped
    public List<CityTB> onStateChange(String id)
    {
        List<CityTB> cityTBs = new ArrayList<CityTB>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from CityTB where StateID=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CityTB c = new CityTB();
                c.setCityID(rs.getInt("cityID"));
                c.setCityName(rs.getString("cityName"));
                //c.setStateID(rs.getInt("stateID"));
               cityTBs.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return cityTBs;
    }
    
}
