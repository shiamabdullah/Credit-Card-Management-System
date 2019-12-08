/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;


import java.sql.PreparedStatement;
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
class AdminCreation extends JFrame{
    JComboBox IDList;
    JLabel UserName, DOB, MotherName, FatherName, BloodGroup,Pass;
    JTextField UserNameText, DOBText, NationalIDText, MotherNameText, FatherNameText, BloodGroupText,PassText;
    JButton Update,Back;
    Container c;
    ImageIcon img = new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    Connection con;
    Statement st;
    ResultSet rs,rsCheck;
    public AdminCreation() {
        icon();
        initComponents();
        visible();

    }

    void initComponents() {
        c = getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        

        
        UserName = new JLabel("User Name :");
        UserName.setBounds(100, 100, 300, 40);
        UserName.setOpaque(false);
        c.add(UserName);
  
        FatherName = new JLabel("Father Name :");
        FatherName.setBounds(100, 150, 300, 40);
        FatherName.setOpaque(false);
        c.add(FatherName);

        MotherName = new JLabel("Mother Name :");
        MotherName.setBounds(100, 200, 300, 40);
        MotherName.setOpaque(false);
        c.add(MotherName);

        String[] IDStrings = { "National ID", "Birth Certificate" };
        JComboBox IDList = new JComboBox(IDStrings);
        IDList.setBounds(100, 250, 120, 40);
        c.add(IDList);


        DOB = new JLabel("Date of Birth :");
        DOB.setBounds(100, 300, 300, 40);
        DOB.setOpaque(false);
        c.add(DOB);

        BloodGroup = new JLabel("Blood Group :");
        BloodGroup.setBounds(100, 350, 300, 40);
        BloodGroup.setOpaque(false);
        c.add(BloodGroup);
        
        
        Pass = new JLabel("Password :");
        
        Pass.setBounds(100, 400, 300, 40);
        Pass.setOpaque(false);
        Pass.setForeground(Color.LIGHT_GRAY);
        c.add(Pass);
    
     //TextField
     
        UserNameText = new JTextField("");
        UserNameText.setBounds(220, 100, 200, 40);
        UserNameText.setOpaque(true);
        c.add(UserNameText);

        FatherNameText = new JTextField("");
        FatherNameText.setBounds(220, 150, 200, 40);
        FatherNameText.setOpaque(true);
        c.add(FatherNameText);

        MotherNameText = new JTextField("");
        MotherNameText.setBounds(220, 200, 200, 40);
        MotherNameText.setOpaque(true);
        c.add(MotherNameText);

        NationalIDText = new JTextField("");
        NationalIDText.setBounds(220, 250, 200, 40);
        NationalIDText.setOpaque(true);
        c.add(NationalIDText);

        DOBText = new JTextField("yyyy-mm-dd");
        DOBText.setBounds(220, 300, 200, 40);
        DOBText.setOpaque(true);
        c.add(DOBText);

        BloodGroupText = new JTextField("");
        BloodGroupText.setBounds(220, 350, 200, 40);
        BloodGroupText.setOpaque(true);
        c.add(BloodGroupText);
        
        PassText = new JTextField("");
        PassText.setBounds(220, 400, 200, 40);
        PassText.setOpaque(true);
        c.add(PassText);
        
        Update =new JButton("Update");
        Update.setBounds(150,450,150,40);
        c.add(Update);
        
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {

             String userName= UserNameText.getText();
             String fatherName = FatherNameText.getText();
             String motherName = MotherNameText.getText();
             String id = NationalIDText.getText();
             String dob = DOBText.getText(); 
             String BG = BloodGroupText.getText();
             String pass = PassText.getText();
             
             System.out.println(userName);
             System.out.println(fatherName);
             System.out.println(motherName);
             System.out.println(id);
             System.out.println(dob);
             System.out.println(BG);
             System.out.println(pass);
             
             PreparedStatement ps;
             String check= "(SELECT `valid`FROM userinfo WHERE `id`=?)UNION(SELECT `valid` FROM admininfo WHERE `id` =?)UNION(SELECT `valid` FROM superadmininfo WHERE `userInput`= ?)";
             String query="INSERT INTO `Admininfo`(`userName`, `fatherName`,`motherName`,`id`,`dob`,`BG`,`pass`) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement psCheck= Connect.getConnection().prepareStatement(check);
            psCheck.setString(1, id);
            psCheck.setString(2, id);
            psCheck.setString(3, id);
            rsCheck=psCheck.executeQuery();
            psCheck.closeOnCompletion();
            ps = Connect.getConnection().prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, fatherName);
            ps.setString(3, motherName);
            ps.setString(4, id);
            ps.setString(5, dob);
            ps.setString(6, BG);
            ps.setString(7, pass );
            
            if(!rsCheck.isBeforeFirst())
            {
                if(ps.executeUpdate() >0){
                JOptionPane.showMessageDialog(null, "Added");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Duplication.Try with another ID");
            }
             }
            else{
                        JOptionPane.showMessageDialog(null,"User id already taken");
                    }
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Format Error or Duplication","Fix Entry",JOptionPane.WARNING_MESSAGE);
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
                superAdminHome SAH = new superAdminHome("");
                
                SAH.setLocationRelativeTo(null);
            }
            });

    }

    void visible() {
        setTitle("Admin Creation");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        setLayout(null);
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);

    }
    public void icon(){    
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
    }
    
    public static void main(String[] args) {
        AdminCreation a1 = new AdminCreation();
    }
    
}
