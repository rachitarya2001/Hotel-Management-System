
package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagement extends JFrame implements ActionListener {
    

    HotelManagement(){
      //  setSize(1100 ,565);
        //setLocation(100,100);
        setBounds(100,60,1100,605);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/one.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1100,565);
        add(image); 
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds( 20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,45));
        image.add(text);
        
        JButton next = new JButton("Click ");
        next.setBounds(900,450,125,50);
        next.setBackground(Color.black);
        next.setForeground(Color.red);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,25));
        image.add(next);
        
        
        setVisible(true);
        
    
        
        while(true){
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
                
            }
            text.setVisible(true);
             try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        }
       
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
        
    }

   
    public static void main(String[] args) {
        new HotelManagement();
       
    }
    
}
