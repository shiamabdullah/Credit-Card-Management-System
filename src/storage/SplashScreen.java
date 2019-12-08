/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.awt.Color;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public final class SplashScreen extends JFrame
{

    private static final long serialVersionUID = 1L;
Container c;

ImageIcon img1= new ImageIcon(getClass().getResource("load.gif"));
      
public SplashScreen()
{
    setTitle("Loading");
try
{
  
        
    c=getContentPane();
    c.setBackground(Color.gray);
    c.setLayout(null);
icon();	
visible();
setSize(600,338);
setLocationRelativeTo(null);
show();
Thread.sleep(2300);
this.dispose();
this.setVisible(false);
        Welcome W=new Welcome();
        icon();
        W.setVisible(true);
        W.setLocationRelativeTo(null); 
        this.dispose();

        
        
        
}
catch(InterruptedException exception)
{
	   
}
        
}
  void visible()
        {
    JLabel imgLabel1= new JLabel(img1);
          imgLabel1.setBounds(0, 0, img1.getIconWidth(), img1.getIconHeight());
        c.add(imgLabel1);
        }

   public void icon(){    
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        this.setUndecorated(true);
    }
   
    public static void main(String[] args) {
        SplashScreen s1= new SplashScreen();
    }

}

