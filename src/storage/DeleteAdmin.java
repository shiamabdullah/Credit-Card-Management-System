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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author root
 */
class DeleteAdmin extends JFrame {
    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    JLabel AdminID;
    JTextField AdminIDText;
    JTable SuperTable;
    ResultSet rs;
   
    JButton DeleteAdmin;
    JButton Back;
    public DeleteAdmin(String text)
    {
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
      
        AdminID = new JLabel("ADMIN ID");
        AdminID.setBounds(500,150 , 180, 20);
        AdminID.setOpaque(false);
        c.add(AdminID);
        AdminIDText = new JTextField("");
        AdminIDText.setBounds(500,190, 200, 30);
        AdminIDText.setOpaque(true);
        c.add(AdminIDText);
        
        
        JButton DeleteAdmin= new JButton("Delete");
        
        DeleteAdmin.setBounds(500,240,100,40);
        c.add(DeleteAdmin);
        DeleteAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {

             String id= AdminIDText.getText();
             
             
             System.out.println(id);
             
             PreparedStatement ps;
             String query="DELETE FROM `Admininfo` WHERE `id` = ?";
        try {
            ps = (PreparedStatement) Connect.getConnection().prepareStatement(query);
      
            ps.setString(1, id);
      
            if(ps.executeUpdate() >0){
                JOptionPane.showMessageDialog(null, "Deleted");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Deletion Error");
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
        
        icon();
        setTitle("Delete Admin");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLayout(null);
        JLabel imgLabel= new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);
    }
    public void icon(){    
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
    }
    
      
}
