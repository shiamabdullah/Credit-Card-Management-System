package storage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author root
 */
import storage.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame {

    
    JButton Login,SignUp,Back;
    JLabel userName;
    JLabel password;
    JLabel SignUpModule;
    JTextField userInput;
    JPasswordField passwordInput;
    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    static String data,adminData,superAdminData;
    public static String u_id;
    public login() {
        
        
       initComponents();
       visible();
        
    }
    
    void initComponents()
    {
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
        
        JButton Login =new JButton("LOGIN");
        JButton SignUp =new JButton("SIGN UP");
        JButton Back =new JButton("BACK");
        
        Login.setBounds(500,350 , 80, 40);
        SignUp.setBounds(280,500,100,40);
        Back.setBounds(600,350,80,40);
        
        c.add(Login);
        c.add(SignUp);
        c.add(Back);
        userName = new JLabel("User ID");
        userName.setBounds(500,150 , 200, 50);
        userName.setOpaque(false);
        userInput = new JTextField("");
        userInput.setBounds(500,190 , 200, 30);
        userInput.setOpaque(true);
        
        password = new JLabel("Password");
        password.setBounds(500,250 , 200, 50);
        password.setOpaque(false);
        
        passwordInput = new JPasswordField("");     
        passwordInput.setBounds(500,290, 200, 30);
        passwordInput.setOpaque(true);
        
        SignUpModule = new JLabel("Don't have an account? Create One");
        SignUpModule.setBounds(200,450 , 300, 40);
        SignUpModule.setOpaque(false);
        
        
        c.add(userName);
        c.add(userInput);
        c.add(password);
        c.add(passwordInput);
        c.add(SignUpModule);
        c.add(Back);
        
        
          Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                
        String id = userInput.getText();
        String pass = String.valueOf(passwordInput.getPassword());
        
        String checkType = "(SELECT `type` FROM userinfo WHERE `id` = ?) UNION (SELECT `type` FROM admininfo WHERE `id` = ?) UNION (SELECT `type` FROM superadmininfo WHERE `userInput` = ?)";
       
        
        String userQuery = "SELECT * FROM `userInfo` WHERE `id` =? AND `pass` =?";
        String userQuery2 = "SELECT `u_id` FROM `userInfo` WHERE `id`=?";           //user_query
        
        String adminQuery = "SELECT * FROM `Admininfo` WHERE `id` =? AND `pass` =?";    //admin_query
        String adminQuery2 = "SELECT `a_id`, FROM `Admininfo` WHERE `id`=?";
        
        
        
                try {ResultSet rsType,rsUser,rsUser2,rsAdmin,rsAdmin2,rsSuperAdmin;
                    int type;
                    
                    PreparedStatement psType= Connect.getConnection().prepareStatement(checkType);
                    psType.setString(1, id);
                    psType.setString(2, id);
                    psType.setString(3, id);
                    rsType= psType.executeQuery();      
                    rsType.next();
                    type= rsType.getInt(1);             //check user ty          
                    psType.close();
                    
                    PreparedStatement psUser=Connect.getConnection().prepareStatement(userQuery);
                    PreparedStatement psUser2=Connect.getConnection().prepareStatement(userQuery2);
                    psUser.setString(1, id);
                    psUser.setString(2, pass);
                    psUser2.setString(1, id);    
                    
                    rsUser=psUser.executeQuery();
                    rsUser2=psUser2.executeQuery(); 
                    psUser2.closeOnCompletion();
                    psUser.closeOnCompletion();
                    
                    PreparedStatement psAdmin = Connect.getConnection().prepareStatement(adminQuery);
                    PreparedStatement psAdmin2 = Connect.getConnection().prepareStatement(adminQuery2);         
                    psAdmin.setString(1, id);
                    psAdmin.setString(2, pass);
                    psAdmin2.setString(1, id);
                    rsAdmin = psAdmin.executeQuery();
                    rsAdmin2=psAdmin2.executeQuery();
                                        
                     
                    
                    switch (type) {
                        case 1:
                            System.out.println("superadmin");
                            
                            break;
                        case 2:
                            if(rsAdmin.next()){
                                 JOptionPane.showMessageDialog(null, "Succesfully Logged In");
                                adminHome UH = new adminHome("");
                                UH.setVisible(true);
                                UH.setLocationRelativeTo(null);
                                dispose();
                                rsAdmin2.next();
                                adminData=rsAdmin2.getString(1);
                                System.out.println(adminData);
                            }
                            else{
                            JOptionPane.showConfirmDialog(null, "Wrong Password Try Again");

                            }
                            break;
                
                            
                        case 3:                     
                            if(rsUser.next()){
                        JOptionPane.showMessageDialog(null, "Succesfully Logged In");
                        UserHome UH = new UserHome("");
                        UH.setVisible(true);
                        UH.setLocationRelativeTo(null);
                        dispose();
                        rsUser2.next();
                        data=rsUser2.getString(1);
                                System.out.println(data);
                            }
                             else{
                        JOptionPane.showConfirmDialog(null, "Wrong Password Try Again");}
                           
                            break;
                            
                        default:
                            throw new AssertionError();
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null,"Database Connection Failure","Fix Database",JOptionPane.ERROR_MESSAGE);

                }
        
        
        
        
        
        
     
       
            } });
        
        
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                Sign SU = new Sign();
                SU.setVisible(true);
                SU.setLocationRelativeTo(null);
            }
            });
        
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                Welcome W = new Welcome();
                W.setVisible(true);
                W.setLocationRelativeTo(null);
            }
            });
        
    }
      
    void visible(){
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("User Login");
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
        login sal = new login();
        sal.setVisible(true);
    }
     
      
    
}

    
