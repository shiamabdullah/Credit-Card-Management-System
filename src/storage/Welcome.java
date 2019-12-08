/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author root
 */

public class Welcome extends JFrame
{
    
    
    JButton StartButton,Back;
    Container c;
    ImageIcon img1= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    JLabel RFID,creation,creator1,creator2;
    public Welcome() {
        
        
        icon();
        initComponents(); 
        visible ();
        
        
    }
    
    void initComponents(){
        c=getContentPane();
        c.setBackground(Color.DARK_GRAY);
        c.setLayout(null);
        
        JLabel RFID= new JLabel("Card Management System");
        RFID.setFont(new Font("Open Sans", Font.BOLD, 30));
        RFID.setBounds(200,20,400,100);
        RFID.setForeground(Color.DARK_GRAY);

        c.add(RFID);
        
        JLabel creation= new JLabel("Created By:");
        creation.setFont(new Font("Open Sans", Font.BOLD, 20));
        creation.setBounds(100,90,200,200);
        creation.setForeground(Color.DARK_GRAY);

        c.add(creation);
         JLabel creator1= new JLabel("Abdullah Al Mamun Shiam");
        
        creator1.setBounds(100,200,300,50);
        creator1.setFont(new Font("Open Sans", Font.BOLD, 17));
        creator1.setForeground(Color.DARK_GRAY);
        creator1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        creator1.addMouseListener(new MouseAdapter(){
 
           @Override
           public void mouseClicked(MouseEvent e) {
              try {
         
           Desktop.getDesktop().browse(new URI("https://www.facebook.com/shiamabdullah1"));
         
             } catch (IOException | URISyntaxException e1) {
               }
              }
 
           @Override
           public void mouseEntered(MouseEvent e) {
           
           creator1.setText("<html><a href=''>Abdullah Al Mamun Shiam</a></html>");
            }
 
           @Override
           public void mouseExited(MouseEvent e) {
           creator1.setText("Abdullah Al Mamun Shiam");
            }
         });

        c.add(creator1);
        
        JLabel creator2= new JLabel("Tamzid Ahmed Fahim");
        creator2.setFont(new Font("Open Sans", Font.BOLD, 17));

        creator2.setBounds(100,240,180,50);
        creator2.setForeground(Color.DARK_GRAY);
        creator2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        creator2.addMouseListener(new MouseAdapter() {
 
           @Override
           public void mouseClicked(MouseEvent e) {
              try {
         
          Desktop.getDesktop().browse(new URI("https://www.facebook.com/Mr.Tvirus"));
         
             } catch (IOException | URISyntaxException e1) {
               }
              }
 
           @Override
           public void mouseEntered(MouseEvent e) {
           
           creator2.setText("<html><a href=''>Tamzid Ahmed Fahim</a></html>");
            }
 
           @Override
           public void mouseExited(MouseEvent e) {
           creator2.setText("Tamzid Ahmed Fahim");
           
            }
         });
        c.add(creator2);
        JLabel creator3= new JLabel("Shahriar Islam Rafat");
        creator3.setBounds(100,280,180,50);
        creator3.setForeground(Color.DARK_GRAY);
                creator3.setFont(new Font("Open Sans", Font.BOLD, 17));

        c.add(creator3);
        
        JLabel website= new JLabel("Visit Our Website");
        website.setBounds(120,480,250,50);
        website.setForeground(Color.LIGHT_GRAY);
        website.setFont(new Font("Open Sans", Font.BOLD, 15));

        website.addMouseListener(new MouseAdapter() {
 
           @Override
           public void mouseClicked(MouseEvent e) {
              try {
         
          Desktop.getDesktop().browse(new URI("https://mrtviruscicada.wixsite.com/website"));
         
             } catch (IOException | URISyntaxException e1) {
               }
              }
 
           @Override
           public void mouseEntered(MouseEvent e) {
           website.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           website.setText("<html><a href=''>CICADA DEVELOPMENT CENTER</a></html>");
            }
 
           @Override
           public void mouseExited(MouseEvent e) {
           website.setText("Visit Our Website");
            }
         });
        c.add(website);
        
        JLabel fbgroup= new JLabel("Visit Our Facebook Group");
        fbgroup.setBounds(350,480,250,50);
        fbgroup.setForeground(Color.LIGHT_GRAY);
        fbgroup.setFont(new Font("Open Sans", Font.BOLD, 15));

        
        fbgroup.addMouseListener(new MouseAdapter() {
 
           @Override
           public void mouseClicked(MouseEvent e) {
              try {
         
          Desktop.getDesktop().browse(new URI("https://www.facebook.com/groups/MrTvirusHUB/"));
         
             } catch (IOException | URISyntaxException e1) {
               }
              }
 
           @Override
           public void mouseEntered(MouseEvent e) {
           fbgroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           fbgroup.setText("<html><a href=''>Mr.Tvirus HUB</a></html>");
            }
 
           @Override
           public void mouseExited(MouseEvent e) {
           fbgroup.setText("Visit Our Facebook Group");
            }
         });
        c.add(fbgroup);
        
        ImageIcon icon1 = new ImageIcon(getClass().getResource("Start.gif"));   
        JButton StartButton = new JButton("Start");
        JButton Back =new JButton("Exit" );     
        StartButton.setBounds(500,200, 200, 50);   
        Back.setBounds(500,300, 200, 50);
        
        c.add(StartButton);
         c.add(Back);     
        c.setFont(new Font("Open Sans", Font.BOLD,30));

        
        
                    
           
           StartButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
                
                dispose();
                loginclass UL = new loginclass();
                UL.setVisible(true);
                UL.setLocationRelativeTo(null);
                
           }
            });

               Back.addActionListener(new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent ae) 
            {
                int result;
              result = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Alert",
                      JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
              if(result == JOptionPane.YES_OPTION)
              {
                    System.exit(0);
              }
              else if (result == JOptionPane.NO_OPTION)
                      {
               
                      
                     }
            }
            });
           

         }
    

         
           
        
    
    
    void visible(){
        
        setTitle("Welcome");
        
        //setVisible(true);
        //setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLayout(null);
        setResizable(false);
        
        JLabel imgLabel1= new JLabel(img1);
        imgLabel1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
        c.add(imgLabel1);
        
        
    }
     public void icon(){    
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        
    }
 
     public static void main(String[] args) {
        Welcome w1= new Welcome();
    }
}


           
    


