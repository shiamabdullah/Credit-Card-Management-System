/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author root
 */
public class DocumentStorage extends JFrame {

    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    JTable SuperTable;
    ResultSet rs;
    JButton Back;
    DefaultTableModel model = new DefaultTableModel();
    //Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    String idno =loginclass.udata;
    DocumentStorage(String text) {
        
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
        
        
        c.setLayout(new FlowLayout(FlowLayout.CENTER));           
        jtbl.getPreferredScrollableViewportSize();
        model.addColumn("Card Type");
        model.addColumn("Card ID");
        model.addColumn("ccv");
        model.addColumn("expiry_date");
        model.addColumn("pin");
        
        
        
       
        jtbl.getColumnModel().getColumn(0).setPreferredWidth(4000);
        jtbl.getColumnModel().getColumn(1).setPreferredWidth(1000);
        jtbl.getColumnModel().getColumn(2).setPreferredWidth(1000);
        jtbl.getColumnModel().getColumn(3).setPreferredWidth(2000);
        jtbl.getColumnModel().getColumn(4).setPreferredWidth(1000);
        
        
        
        
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rfid?zeroDateTimeBehavior=convertToNull", "root", "");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM `Add_Document_User`WHERE `u_id_fn` = ? ");
            pstm.setString(1, idno);
            
            System.out.println(idno);
            
            ResultSet Rs = pstm.executeQuery();
            
            
            while(Rs.next()){
          
           
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5)});
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Database Connection Failure","Fix Database",JOptionPane.ERROR_MESSAGE);
        }
        JScrollPane pg = new JScrollPane(jtbl);
        c.add(pg);
        this.pack();
               
        
        JButton Back= new JButton("BACK");
        
        Back.setBounds(480,500,100,40);
        c.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                UserHome UH = new UserHome("");
                UH.setVisible(true);
                UH.setLocationRelativeTo(null);
            }
            });
        
       
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("View Document");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLayout(null);
        JLabel imgLabel= new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);
       
        
        
        
    }
     public static void main(String[] args) {
        DocumentStorage sal = new DocumentStorage("");
        sal.setVisible(true);
        sal.setLocationRelativeTo(null);
    }
 
    
 } 

       
