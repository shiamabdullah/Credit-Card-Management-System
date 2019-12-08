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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
/**
 *
 * @author root
 */
class UpdateSUAdminPass extends JFrame {
    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    JLabel OldPass,NewPass,ConfirmPass;
    JPasswordField OldPassText,NewPassText,ConfirmPassText;
    JTable SuperTable;
    ResultSet rs,rs2;
    String SDATA;
    JButton PassReset;
    JButton Back;
    PreparedStatement ps;
    String oldpass;
    public UpdateSUAdminPass(String text)
    {
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        SDATA= loginclass.sadata;

        OldPass = new JLabel("Old Password");
        OldPass.setBounds(500,150 , 180, 20);
        OldPass.setOpaque(false);
        c.add(OldPass);
        OldPassText = new JPasswordField("");
        OldPassText.setBounds(500,190, 200, 30);
        OldPassText.setOpaque(true);
        c.add(OldPassText);
        
        NewPass = new JLabel("New Password");
        NewPass.setBounds(500,250 , 180, 20);
        NewPass.setOpaque(false);
        c.add(NewPass);
        NewPassText = new JPasswordField("");
        NewPassText.setBounds(500,290, 200, 30);
        NewPassText.setOpaque(true);
        c.add(NewPassText);
        
        ConfirmPass = new JLabel("Confirm Password");
        ConfirmPass.setBounds(500,350 , 180, 20);
        ConfirmPass.setOpaque(false);
        c.add(ConfirmPass);
        ConfirmPassText = new JPasswordField("");
        ConfirmPassText.setBounds(500,390, 200, 30);
        ConfirmPassText.setOpaque(true);
        c.add(ConfirmPassText);
        
        JButton PassReset= new JButton("Reset Password");
        
        PassReset.setBounds(500,450,200,40);
        c.add(PassReset);
        
        
        PassReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
             
             String query1 = "UPDATE `superAdmininfo` SET`passwordInput`=? WHERE `s_id`=?";
             String query2="SELECT `passwordInput`FROM `superAdmininfo` WHERE `s_id`=?";
             
             String oldInput=OldPassText.getText();
             String newInput=NewPassText.getText();
             String ConfirmInput= ConfirmPassText.getText();
           
                try {
                    PreparedStatement ps2 = (PreparedStatement) Connect.getConnection().prepareStatement(query2);
                    ps2.setString(1, SDATA);
                    rs2 = ps2.executeQuery();
                    rs2.next();
                    oldpass=rs2.getString(1);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateSUAdminPass.class.getName()).log(Level.SEVERE, null, ex);
                }
             
             
             System.out.println(oldInput);
        try {
            if(newInput.equals(ConfirmInput) && oldpass.equals(oldInput))
                
            {   ps = (PreparedStatement) Connect.getConnection().prepareStatement(query1);           
                ps.setString(1, newInput);
                ps.setString(2,SDATA);
                
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Password Mismatch");
                
            }
            if(ps.executeUpdate() >0){
                JOptionPane.showMessageDialog(null, "Password Rested");
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Reset Error");
            }
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Database Connection Failure","Fix Database",JOptionPane.ERROR_MESSAGE);
        }
            }
            });
        
        
        
        JButton Back= new JButton("Back");
        
        Back.setBounds(280,500,100,40);
        c.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                superAdminHome SAL = new superAdminHome("");
                SAL.setVisible(true);
                SAL.setLocationRelativeTo(null);
            }
            });
        
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("Reset CEO Password");
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
