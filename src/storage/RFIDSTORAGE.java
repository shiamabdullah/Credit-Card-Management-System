/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JFrame;



/**
 *
 * @author root
 */
public class RFIDSTORAGE extends JFrame{
    
     RFIDSTORAGE()
     {
         icon();
     }
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        
        SplashScreen sp=new SplashScreen();
      
        
         
    } 
    public void icon(){    
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        
    }
         
   
  }
