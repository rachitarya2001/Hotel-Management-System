
package hotel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JFrame;
import java.util.Date;
import java.awt.event.*;

public class Checkout  extends JFrame  implements ActionListener{
    
    Choice customer;
    JLabel lbroomnumber, lbcheckintime , lbcheckouttime;
    JButton checkout,back;
   
    Checkout(){
        
    getContentPane().setBackground(Color.white);
    setLayout(null);
    
    JLabel text = new JLabel("Checkout");
    text.setBounds(100, 20, 100, 30);
    text.setForeground(Color.blue);
    text.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(text);
    
    JLabel lbid = new JLabel("Customer Id");
    lbid.setBounds(30, 80, 100, 30);
    add(lbid);
    
    customer = new Choice();
        customer.setBounds(150,80,120,25);
        add(customer);
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ticke.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel ticke = new JLabel(i3);
        ticke.setBounds(280, 80, 20, 20);
        add(ticke);
        
        
        JLabel lbroom = new JLabel("Room Number");
        lbroom.setBounds(30, 130, 100, 30);
        add(lbroom);
        
        
        lbroomnumber = new JLabel();
        lbroomnumber.setBounds(150, 130, 100, 30);
        add(lbroomnumber);
        
        JLabel lbcheckin = new JLabel("Checkin Time");
        lbcheckin.setBounds(30, 180, 100, 30);
        add(lbcheckin);
        
        
        lbcheckintime = new JLabel();
        lbcheckintime.setBounds(150, 180, 150, 30);
        add(lbcheckintime);
        
        
        JLabel lbcheckout = new JLabel("Checkout Time");
        lbcheckout.setBounds(30, 230, 100, 30);
        add(lbcheckout);
        
        Date date = new Date();
        lbcheckouttime = new JLabel("" + date);
        lbcheckouttime.setBounds(150, 230, 150, 30);
        add(lbcheckouttime);
        
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        checkout.setBounds(30,280,120,30);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(170,280,120,30);
        add(back);
        
        
        try{
            conn c = new conn();
            
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
                
                lbroomnumber.setText(rs.getString("room"));
                lbcheckintime.setText(rs.getString("checkintime"));
            }
            
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixthh.jpg"));
        Image i5 = i4.getImage().getScaledInstance(430, 350, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(370, 50, 430, 350);
        add(image);
        

    
    
    
    
    setBounds(250,100,900,500);
    setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout){
            
            String query1 = "delete from customer where number = '"+customer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where roomnumber = '"+lbroomnumber.getText()+"'";
            
            try{
                
                conn c = new conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Checkout done");  
                
                setVisible(false);
                new Reception();

                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
            new Reception();
        }
    } 
    public static void main(String [] args){
        new Checkout();
    }
}
