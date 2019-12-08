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
class NewDocument extends JFrame {
     
    JComboBox CardList;
    String[] CardStrings = { "EBL Visa Classic Credit Card", "EBL Visa Gold Credit Card", "EBL Visa Platinum Credit", "Mastercard Titanium Credit", "Mastercard World Credit","EBL Diners Club " };
    JLabel CardListTape,CardSelection;
    JTextField CardSelectionText;
    JButton Update,Back;
    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    PreparedStatement ps,ps2,ps3,ps4;
    Statement st;
    ResultSet rs,rs2,rs3;
    String data;
    int i,k;
    public NewDocument() {

        initComponents();
        visible();
        data= loginclass.udata;
        System.out.println(data);
        
    }

    void initComponents() {
         c = getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        

        
       c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
 
        
        JComboBox CardList = new JComboBox(CardStrings);
        CardList.setBounds(200,100,300,40);
        c.add(CardList);
        
      
         
        CardListTape = new JLabel("Available:");
        CardListTape.setBounds(100,100 , 300, 40);
        CardListTape.setOpaque(false);
        c.add(CardListTape);
        
        
        CardSelection = new JLabel("Card Select:");
        CardSelection.setBounds(100,200 , 300, 40);
        CardSelection.setOpaque(false);
        c.add(CardSelection);
         
       
        CardSelectionText =new JTextField("");
        CardSelectionText.setBounds(200,200 , 300, 40);
        CardSelectionText.setOpaque(true);
        CardSelectionText.setEditable(false);
        c.add(CardSelectionText);
        
        CardList.addActionListener(new ActionListener()
                {
            
                @Override      
                public void actionPerformed(ActionEvent ae)
                {           
                 CardSelectionText.setText(CardList.getSelectedItem().toString());
                }        
                });
        Update =new JButton("Issue");
        Update.setBounds(200,350,150,40);
        c.add(Update);
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {   
               
                
               String Card_Type= CardSelectionText.getText();
                        
               String query = "INSERT INTO `Add_Document_User`(`Card_Type`,`u_id_fn`) VALUES (?,?)";
               
                try{
                    
                 
                    ps = (PreparedStatement) Connect.getConnection().prepareStatement(query);
                    ps.setString(1,Card_Type);
                    ps.setString(2,data);
                    
                    if(ps.executeUpdate() >0)
                    {
                        JOptionPane.showMessageDialog(null,"Card added");
                        
                        String query2="SELECT MAX(`Card_ID`) FROM `Add_Document_User`";
                        ps2 = (PreparedStatement) Connect.getConnection().prepareStatement(query2);
                        rs2 = ps2.executeQuery();
                        rs2.next();
                        i=rs2.getInt(1);
                        System.out.println(i);
                        i++;
                        System.out.println(i);
                        
                        String query4="SELECT MAX(`c_id`) FROM `Add_Document_User`";
                        ps4= (PreparedStatement) Connect.getConnection().prepareStatement(query4);
                        rs3 = ps4.executeQuery();
                        rs3.next();
                        k=rs3.getInt(1);
                        
                        
                        String query3="UPDATE `Add_Document_User` SET `Card_ID`=? WHERE `c_id` =?";
                        ps3 = (PreparedStatement) Connect.getConnection().prepareStatement(query3);
                        ps3.setInt(1,i);
                        ps3.setInt(2,k);
                        ps3.executeUpdate();
                        System.out.println(i);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"User not Added");
                    }
                   }
                catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null,"Database Connection Failure","Fix Database",JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
         JButton Back =new JButton("BACK");
        Back.setBounds(380,350,150,40);
        c.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                UserHome UL = new UserHome("");
                UL.setVisible(true);
                UL.setLocationRelativeTo(null);
            }
            });

    }

    void visible() {
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("Issue Card");
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
        NewDocument S = new NewDocument();
        S.setVisible(true);
    }

}
