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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author root
 */
class adminHome extends JFrame{
    
    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    
    JButton Back,VerifyUser;
    JButton userDeletion,ResetPass;
    adminHome(String text)
    {
        initComponents();
        visible();
    }
    
    
    void initComponents()
    {
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
        
        JButton Back= new JButton("LOG OUT");
        
        Back.setBounds(500,450 , 200, 50);
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
        
        JButton ResetPass= new JButton("Reset Password");
        
        ResetPass.setBounds(500,350 , 200, 50);
        c.add(ResetPass);
        ResetPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                UpdateAdminPass USAP = new UpdateAdminPass("");
                USAP.setVisible(true);
                USAP.setLocationRelativeTo(null);
            }
            });
        
        
        JButton userDeletion =new JButton("Delete User");
       userDeletion.setBounds(500,250 , 200, 50);
        c.add(userDeletion);
        userDeletion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                UserDeletion UV = new UserDeletion("");
                UV.setVisible(true);
                UV.setLocationRelativeTo(null);
            }
            });
        
        JButton VerifyUser= new JButton("Update Issued Card");
        VerifyUser.setBounds(500,150 , 200, 50);
        c.add(VerifyUser);
        VerifyUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                UserVerification UV = new UserVerification("");
                UV.setVisible(true);
                UV.setLocationRelativeTo(null);
            }
            });
        
    }
    
    void visible()
    {
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("Admin Home");
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
        loginclass sal = new loginclass();
        sal.setVisible(true);
    }
    
}
