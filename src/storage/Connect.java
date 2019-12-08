/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;
import java.sql.*;

class Connect{

  public static Connection getConnection(){
     
        Connection con = null;
        try {
           Class.forName("com.mysql.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rfid?zeroDateTimeBehavior=convertToNull","root","");
            
        }
       catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
   
}