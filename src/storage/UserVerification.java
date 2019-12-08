package storage;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import storage.UserHome;
import storage.login;

public class UserVerification extends JFrame {

    Container c;
    ImageIcon img= new ImageIcon(getClass().getResource(BackgroundImage.wallpaper));
    JTable SuperTable;
    ResultSet rs,rs2;
    JButton Back;
    JTextField CardInput;
    static String C_ID;
    String Card;
    DefaultTableModel model = new DefaultTableModel();
    //Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    UserVerification(String text) {
        
        c=getContentPane();
        c.setBackground(Color.gray);
        c.setLayout(null);
        
        JButton Back = new JButton("BACK");
        
        CardInput = new JTextField("Insert CARD ID");
        CardInput.setBounds(500,500,200,50);
        CardInput.setOpaque(true);
        
        
        JButton Update =new JButton("Update");
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
               String query2="SELECT `Card_ID` FROM `Add_Document_User` WHERE `Card_ID`=?";
               
               String Card=CardInput.getText();
                System.out.println(Card);
               try {
                    com.mysql.jdbc.PreparedStatement ps2 = (com.mysql.jdbc.PreparedStatement) Connect.getConnection().prepareStatement(query2);
                    ps2.setString(1, Card);
                    rs2 = ps2.executeQuery();
                     if(rs2.next())
                     {
                    C_ID=rs2.getString(1);
                    
                    dispose();
                    CardUpdate UH = new CardUpdate("");
                    UH.setVisible(true);
                    UH.setLocationRelativeTo(null);
                     }
                     else
                     {
                    JOptionPane.showMessageDialog(null,"Card not Detected");     
                     }
                    } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Database Connection Failure","Fix Database",JOptionPane.ERROR_MESSAGE);
                }
            }
            });
        c.add(CardInput);
         Update.setBounds(480,500,100,40);
        c.add(Update);

        c.setLayout(new FlowLayout(FlowLayout.CENTER));           
        jtbl.getPreferredScrollableViewportSize();
        model.addColumn("Card Type");
        model.addColumn("Card ID");
        model.addColumn("ccv");
        model.addColumn("expiry_date");
        model.addColumn("pin");
        model.addColumn("ID Trace");

       
        jtbl.getColumnModel().getColumn(0).setPreferredWidth(300);
        jtbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        jtbl.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtbl.getColumnModel().getColumn(3).setPreferredWidth(200);
        jtbl.getColumnModel().getColumn(4).setPreferredWidth(100);
        jtbl.getColumnModel().getColumn(5).setPreferredWidth(100);
            
       
        
        
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rfid?zeroDateTimeBehavior=convertToNull", "root", "");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM `Add_Document_User`");
            
            
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Database Connection Failure","Fix Database",JOptionPane.ERROR_MESSAGE);
        }
        JScrollPane pg = new JScrollPane(jtbl);
        c.add(pg);
        this.pack();
         
        
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                dispose();
                adminHome UH = new adminHome("");
                UH.setVisible(true);
                UH.setLocationRelativeTo(null);
            }
            });
       
           Back.setBounds(480,500,100,40);
        c.add(Back);
        
        //JButton Update= new JButton("Update");
           
           
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        setTitle("Update Issued Card");
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
        UserVerification sal = new  UserVerification("");
        sal.setVisible(true);
        sal.setLocationRelativeTo(null);
    }
 
    
 } 

       
