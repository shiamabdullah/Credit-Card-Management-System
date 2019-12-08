/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author root
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class UserList extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public UserList(String text) {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));           
        jtbl.getPreferredScrollableViewportSize();
        model.addColumn("Card Type");
        model.addColumn("Card ID");
        model.addColumn("ccv");
        model.addColumn("expiry_date");
        model.addColumn("pin");
        model.addColumn("u_id_fn");
        
        
        
        jtbl.getColumnModel().getColumn(0).setPreferredWidth(300);
        jtbl.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtbl.getColumnModel().getColumn(2).setPreferredWidth(200);
        jtbl.getColumnModel().getColumn(3).setPreferredWidth(200);
        jtbl.getColumnModel().getColumn(4).setPreferredWidth(200);
        jtbl.getColumnModel().getColumn(5).setPreferredWidth(200);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rfid?zeroDateTimeBehavior=convertToNull", "root", "");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM Add_Document_User WHERE u_id_fn=8");
           
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
    public static void main(String[] args) {
        JFrame frame = new UserList("");
        frame.setTitle("Document Storage");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}