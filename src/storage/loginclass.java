/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author root
 */
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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginclass extends JFrame {

    
    JButton Login,SignUp,Back;
    JLabel userName;
    JLabel password;
    JLabel SignUpModule;
    JTextField userInput;
    JPasswordField passwordInput;
    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    public static String adata,udata,sadata;
    public static String u_id;
    public loginclass() {
        
        
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
        JCheckBox showPassword= new JCheckBox("show password");
      
        Login.setBounds(500,360 , 80, 40);
        SignUp.setBounds(280,500,100,40);
        Back.setBounds(600,360,80,40);
        showPassword.setBounds(498,325,200,30);
        showPassword.setToolTipText("Show Password");
        showPassword.setForeground(Color.black);
        showPassword.setOpaque(false);
        
        c.add(Login);
        c.add(SignUp);
        c.add(Back);
        c.add(showPassword);
        userName = new JLabel("User ID");
        userName.setBounds(500,150 , 200, 50);
        userName.setOpaque(false);
        userInput = new JTextField("");
        userInput.setBounds(500,190 , 200, 30);
        userInput.setOpaque(true);
        
        password = new JLabel("Password");
        password.setBounds(500,250,200,50);
        password.setOpaque(false);
        
        passwordInput = new JPasswordField("");     
        passwordInput.setBounds(500,290, 200, 30);
        passwordInput.setOpaque(true);
        
        SignUpModule = new JLabel("Don't have an account? Create One");
        SignUpModule.setBounds(200,450 , 300, 40);
        SignUpModule.setForeground(Color.LIGHT_GRAY);
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
        
        
        String aQuery = "SELECT * FROM `Admininfo` WHERE `id` =? AND `pass` =?";
        String aQuery2 = "SELECT `a_id` FROM `Admininfo` WHERE `id`=?";
        
        String sQuery = "SELECT * FROM `superAdmininfo` WHERE `userInput` =? AND `passwordInput` =?";
        String sQuery2 = "SELECT `s_id` FROM `superAdmininfo` WHERE `userInput`=?";

        
        
                try {ResultSet rs,rs2,rsType,rsUser,rsUser2,rsAdmin,rsAdmin2,rsSuperAdmin,rsSuperAdmin2;
                    int type;
                    
                    PreparedStatement psType= Connect.getConnection().prepareStatement(checkType);
                    psType.setString(1, id);
                    psType.setString(2, id);
                    psType.setString(3, id);
                    rsType= psType.executeQuery();      
                    rsType.next();
                    type= rsType.getInt(1);             //check user ty          
                                        
                    PreparedStatement psUser=Connect.getConnection().prepareStatement(userQuery);
                    PreparedStatement psUser2=Connect.getConnection().prepareStatement(userQuery2);
                    psUser.setString(1, id);
                    psUser.setString(2, pass);
                    psUser2.setString(1, id);    
                    
                    rsUser=psUser.executeQuery();
                    rsUser2=psUser2.executeQuery();   
                    psUser2.closeOnCompletion();
                    psUser.closeOnCompletion();
                    
                    PreparedStatement ps = Connect.getConnection().prepareStatement(aQuery);
                    PreparedStatement ps2 = Connect.getConnection().prepareStatement(aQuery2);

                    ps.setString(1, id);
                    ps.setString(2, pass);
                    ps2.setString(1, id);
                    
                    rs = ps.executeQuery();
                    rs2=ps2.executeQuery();
                    

                    PreparedStatement psSuper = Connect.getConnection().prepareStatement(sQuery);
                    PreparedStatement psSuper2 = Connect.getConnection().prepareStatement(sQuery2);
            
                    psSuper.setString(1, id);
                    psSuper.setString(2, pass);
                    psSuper2.setString(1, id);

                    rsSuperAdmin = psSuper.executeQuery();
                    rsSuperAdmin2 = psSuper2.executeQuery();

                    
                    switch (type) {
                        case 1:
                             if(rsSuperAdmin.next())
            {
                    
                        JOptionPane.showMessageDialog(null, "Logged in to CEO account");
                        superAdminHome UH = new superAdminHome("");
                         UH.setVisible(true);
                         UH.setLocationRelativeTo(null);
                        dispose();
                        rsSuperAdmin2.next();
                        sadata=rsSuperAdmin2.getString(1);
                        System.out.println(sadata);
            }
                    else{
                        JOptionPane.showConfirmDialog(null, "Wrong Password Try Again");
                        
                    }
                            System.out.println("superadmin");
                            
                            break;
                            
                        case 2:
                         if(rs.next())
            {
                    
                        JOptionPane.showMessageDialog(null, "Logged in to Admin account");
                        adminHome UH = new adminHome("");
                         UH.setVisible(true);
                         UH.setLocationRelativeTo(null);
                        dispose();
                        rs2.next();
                        adata=rs2.getString(1);
                        System.out.println(adata);
                        System.out.println(type);
                        
            }
                    else{
                        JOptionPane.showConfirmDialog(null, "Wrong Password Try Again");
                        
                    }
                    
                 
                            break;
                            
                        case 3:                     
                            if(rsUser.next()){
                        JOptionPane.showMessageDialog(null, "Logged in to User account");
                        UserHome UH = new UserHome("");
                        UH.setVisible(true);
                        UH.setLocationRelativeTo(null);
                        dispose();
                        rsUser2.next();
                        udata=rsUser2.getString(1);
                        System.out.println(udata);
                        
                                System.out.println(type);                                
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
        
     
        
        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {if(showPassword.isSelected())
            {   passwordInput.setEchoChar((char)0);
            }
            else{
                 passwordInput.setEchoChar('*');
            }
            
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
        loginclass sal = new loginclass();
        sal.setVisible(true);
    }
     
      
    
}

    
