
package hotel.management;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom  extends JFrame implements ActionListener{
    
    Choice customer;
    JTextField tfroom, tfavailable,tfstatus,tfdeposit,tfpaid,tfpending;
    JButton check,update,back;
    
    UpdateRoom(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma" , Font.PLAIN,25));
        text.setBounds(30, 20, 250, 30);
        text.setForeground(Color.blue);
        add(text);
        
        
        
        JLabel lbid = new JLabel("Customer Id");
        lbid.setBounds(30, 80, 100, 20);
        add(lbid);
        
        customer = new Choice();
        customer.setBounds(200,80,150,25);
        add(customer);
        
        try{
            conn c = new conn();
            
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customer.add(rs.getString("number"));
            }
            
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
        
        
        JLabel lbroom = new JLabel("Room  Number");
        lbroom.setBounds(30, 130, 100, 20);
        add(lbroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);
        
        
        JLabel lbname = new JLabel("Availability");
        lbname.setBounds(30, 180, 100, 20);
        add(lbname);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);
        
        
        JLabel lbcheckin = new JLabel("Cleaning Status");
        lbcheckin.setBounds(30, 230, 100, 20);
        add(lbcheckin);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);
        
        
        
        check = new JButton ("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        
        update = new JButton ("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        
        back = new JButton ("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/sev.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
    




        
        setBounds(200,100,980,450);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            
            String id = customer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            
            try{
                
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                    
                }
                
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
                while(rs2.next()){
                    
                   tfavailable.setText(rs2.getString("availability"));
                   tfstatus.setText(rs2.getString("cleaning_status"));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        }else if(ae.getSource() == update){
            
            String number = customer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
            
        
            
            try{
                conn c = new conn();
                c.s.executeUpdate("update room set availability = '"+available+"',cleaning_status = '"+status+"' where roomnumber = '"+room+"'");
                JOptionPane.showMessageDialog(null,"Data Update Successfully");
                
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        
        }else if(ae.getSource()== back){
            
            setVisible(false);
            new Reception();
        
        }
    
    }
    
    public static void main(String [] args){
        
        new UpdateRoom();
    }
    
}
