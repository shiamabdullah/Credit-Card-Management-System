/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
/**
 *
 * @author root
 */
public class superAdminHome extends JFrame {

    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    JTable SuperTable;
    ResultSet rs;
    
    JButton CreateAdmin;
    JButton SuperData;
    JButton DeleteAdmin,DeleteUser;
    JButton Back;
    JButton UpdateSUpass; 
    superAdminHome(String text) {
        
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
        
        
        JButton CreateAdmin= new JButton("Create Admin");
        
        CreateAdmin.setBounds(500,100 , 200, 50);
        c.add(CreateAdmin);
        CreateAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                AdminCreation AC = new AdminCreation();
                AC.setVisible(true);
                AC.setLocationRelativeTo(null);
            }
            });
        
        JButton DeleteAdmin= new JButton("Delete Admin");
        
        DeleteAdmin.setBounds(500,190 , 200, 50);
        c.add(DeleteAdmin);
       DeleteAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                DeleteAdmin AD = new DeleteAdmin("");
                AD.setVisible(true);
                AD.setLocationRelativeTo(null);
            }
            });
        
       JButton DeleteUser= new JButton("Delete User");
        
        DeleteUser.setBounds(500,280 , 200, 50);
       c.add(DeleteUser);
       DeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                S_UserDeletion AD = new S_UserDeletion("");
                AD.setVisible(true);
                AD.setLocationRelativeTo(null);
            }
            });
        
        JButton SuperData= new JButton("View All Data");
        
        SuperData.setBounds(500,370 , 200, 50);
        c.add(SuperData);
        SuperData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                ViewSuperData VSD = null;
                try {
                    VSD = new ViewSuperData("");
                } catch (IOException ex) {
                    Logger.getLogger(superAdminHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(superAdminHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                VSD.setVisible(true);
                VSD.setLocationRelativeTo(null);
            }
            });
        
        JButton UpdateSUpass= new JButton("Reset Password");
        
        UpdateSUpass.setBounds(500,460 , 200, 50);
        c.add(UpdateSUpass);
        UpdateSUpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                UpdateSUAdminPass USAP = new UpdateSUAdminPass("");
                USAP.setVisible(true);
                USAP.setLocationRelativeTo(null);
            }
            });
        
        JButton Back= new JButton("LOG OUT");
        
        Back.setBounds(280,500,100,40);
        c.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                loginclass SAL = new loginclass();
                SAL.setVisible(true);
                SAL.setLocationRelativeTo(null);
            }
            });
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("CEO Home");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLayout(null);
        JLabel imgLabel= new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);
    }
 
    
 } 

       
