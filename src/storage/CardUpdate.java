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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author root
 */
class CardUpdate extends JFrame {
    JComboBox IDList;
    JLabel u_id, Card_Id, ccv, expiry_date, pin,TracedID;
    JTextField u_idText, Card_IdText, ccvText, expiry_dateText, pinText;
    JButton Update,Back;
    Container c;
    ImageIcon img = new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    String C_ID=UserVerification.C_ID;
    public CardUpdate(String text) {

        initComponents();
        visible();

    }

    void initComponents() {
         c = getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
        u_id = new JLabel();
        u_id.setBounds(100, 60, 300, 40);
        u_id.setOpaque(false);
        c.add(u_id);
        
        
         Card_Id= new JLabel("CARD ID :");
        Card_Id.setBounds(100, 150, 300, 40);
        Card_Id.setOpaque(false);
        c.add(Card_Id);

        ccv = new JLabel("CCV :");
        ccv.setBounds(100, 200, 300, 40);
        ccv.setOpaque(false);
        c.add(ccv);

        expiry_date = new JLabel("Expiry Date:");
        expiry_date.setBounds(100, 250, 300, 40);
        expiry_date.setOpaque(false);
        c.add(expiry_date);


        pin = new JLabel("pin :");
        pin.setBounds(100, 300, 300, 40);
        pin.setOpaque(false);
        c.add(pin);

     //TextField
     


        TracedID = new JLabel(C_ID);
        TracedID.setBounds(220, 150, 200, 40);
        TracedID.setOpaque(false);
        c.add(TracedID);

        ccvText = new JTextField("");
        ccvText.setBounds(220, 200, 200, 40);
        ccvText.setOpaque(true);
        c.add(ccvText);

        expiry_dateText = new JTextField("yyyy-mm-dd");
        expiry_dateText.setBounds(220, 250, 200, 40);
        expiry_dateText.setOpaque(true);
        c.add(expiry_dateText);

        pinText = new JTextField("");
        pinText.setBounds(220, 300, 200, 40);
        pinText.setOpaque(true);
        c.add(pinText);


        Update =new JButton("Update");
        Update.setBounds(150,450,150,40);
        c.add(Update);
        
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
             
                    String Card_Id = C_ID;
                    String ccv = ccvText.getText();
                    String expiry_date = expiry_dateText.getText();
                    String pin = pinText.getText();
                    String Card=C_ID;
                    
                    
                
                    System.out.println(Card_Id);
                    System.out.println(ccv);
                    System.out.println(expiry_date);
                    System.out.println(pin);
                    System.out.println(C_ID);
                    
                    String query = "UPDATE `Add_Document_User` SET `Card_ID`=?,`ccv`=?,`expiry_date`=?,`pin`=? WHERE `Card_ID` =?";
                try{
                    
                 
                    ps = (PreparedStatement) Connect.getConnection().prepareStatement(query);
       
                    ps.setString(1,Card_Id);
                    ps.setString(2,ccv);
                    ps.setString(3,expiry_date);
                    ps.setString(4,pin);
                    ps.setString(5,C_ID);
                    
                    if(ps.executeUpdate() >0)
                    {
                        JOptionPane.showMessageDialog(null,"Card Updated");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Card not Updated");
                    }
                   }
                catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null,"Format Error","Fix Entry",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton Back =new JButton("BACK");
        Back.setBounds(350,450,150,40);
        c.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                UserVerification UL = new UserVerification("");
                UL.setVisible(true);
                UL.setLocationRelativeTo(null);
            }
            });
    }

    void visible() {
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("Card Number " +C_ID);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLayout(null);
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);

    }

    public static void main(String[] args) {
        CardUpdate S = new CardUpdate("");
        
        
        S.setVisible(true);
    }

}
