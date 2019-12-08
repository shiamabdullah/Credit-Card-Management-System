/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;


import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
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
public class ViewSuperData extends JFrame {

    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    JTable SuperTable;
    ResultSet rs;
    
    JButton Back,ViewWeb,ViewInSof;
     
    ViewSuperData(String text) throws IOException, URISyntaxException {
        
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
        JButton ViewWeb= new JButton("Control From Web");
        
        ViewWeb.setBounds(500,100 , 200, 50);
        c.add(ViewWeb);
        ViewWeb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) 
                 {
                    try {
                        Desktop.getDesktop().browse(new URI("http://localhost/phpmyadmin/db_structure.php?server=1&db=rfidstorage"));
                    } catch (URISyntaxException | IOException ex) {
                        Logger.getLogger(ViewSuperData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
            }
            });
        
        JButton ViewInSof1= new JButton("Visit Database of CARD");
        ViewInSof1.setBounds(500,190 , 200, 50);
        c.add(ViewInSof1);
        ViewInSof1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                ViewInSof1 SAH = new ViewInSof1("");
                SAH.setVisible(true);
                SAH.setLocationRelativeTo(null);
            }
            });
           
        
        JButton ViewInSof2= new JButton("Visit Database of Admin");
        ViewInSof2.setBounds(500,280 , 200, 50);
        c.add(ViewInSof2);
        ViewInSof2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                ViewInSof2 SAH = new ViewInSof2("");
                SAH.setVisible(true);
                SAH.setLocationRelativeTo(null);
            }
            });
        
         JButton ViewInSof3= new JButton("Visit Database of User");
        ViewInSof3.setBounds(500,370 , 200, 50);
        c.add(ViewInSof3);
        ViewInSof3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                ViewInSof3 SAH = new ViewInSof3("");
                SAH.setVisible(true);
                SAH.setLocationRelativeTo(null);
            }
            });
        JButton Back= new JButton("BACK");
        
        Back.setBounds(500,460 , 200, 50);
        c.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                superAdminHome SAH = new superAdminHome("");
                SAH.setVisible(true);
                SAH.setLocationRelativeTo(null);
            }
            });
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("Control Database");
        setResizable(false);
       setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLayout(null);
        JLabel imgLabel= new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel); 
    }
     public static void main(String[] args) throws IOException, URISyntaxException {
        ViewSuperData sal = new ViewSuperData("");
        sal.setVisible(true);
    }
 
    
 } 

       
