/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author root
 */
public class UserHome extends JFrame{
    JLabel UserHome;
    JButton AddDocument,DocumentStorage,Back,ResetPass;
    Container c;
     PreparedStatement ps;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
   
    
    public UserHome(String text)
    {
        initComponents();
        visible();
    }
    
    void initComponents()
    {
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
       
       
        
        JButton AddDocument = new JButton("ADD DOCUMENT");
        JButton DocumentStorage = new JButton("View All Documents");
        JButton Back=new JButton("LOG OUT");
        
        AddDocument.setBounds(500,150 , 200, 40);
        DocumentStorage.setBounds(500,200,200,40);
        Back.setBounds(500,350,200,40);
        
        c.add(AddDocument);
        c.add(DocumentStorage);
        c.add(Back);
        
        AddDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                NewDocument UH = new NewDocument();
                UH.setVisible(true);
                UH.setLocationRelativeTo(null);
            }
            });
        
        
        
       DocumentStorage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                DocumentStorage DS = new DocumentStorage("");
                DS.setVisible(true);
                DS.setLocationRelativeTo(null);
            }
            });
        
        JButton ResetPass= new JButton("Reset Password");
        
        ResetPass.setBounds(500,250 , 200, 50);
        c.add(ResetPass);
        ResetPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                UpdateUserPass USAP = new UpdateUserPass("");
                USAP.setVisible(true);
                USAP.setLocationRelativeTo(null);
            }
            });
    
          Back.addActionListener(new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent ae) 
            {
                
                dispose();
                loginclass UL = new loginclass();
                UL.setVisible(true);
                UL.setLocationRelativeTo(null);
                
            }
            });
    }
    
    void visible()
    {
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("User Home");
         setVisible(true);
         setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLayout(null);
        JLabel imgLabel= new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);
    }
    
 
    
     public static void main(String[] args) {
        UserHome sal = new UserHome("");
        sal.setVisible(true);
    }
}
