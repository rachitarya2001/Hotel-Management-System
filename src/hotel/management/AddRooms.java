
package hotel.management;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {
    
    JButton add, cancel;
    JTextField tfroom , tfprice;
    JComboBox typecombo, availablecombo, cleancombo;
    
    AddRooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lbrommno = new JLabel(" Room Number");
        lbrommno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbrommno.setBounds(60,80,120,30);
        add( lbrommno);
         
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        
        JLabel lbavailable = new JLabel(" Available");
        lbavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbavailable.setBounds(60,130,120,30);
        add( lbavailable);
        
        
        String availableOption[] = {"Available","Occupied"};
        
        availablecombo = new JComboBox(availableOption);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        
        
        JLabel lbclean = new JLabel(" Cleaning Status");
        lbclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbclean.setBounds(60,180,120,30);
        add( lbclean);
        
        
        String cleanOption[] = {"Cleaned","Dirty"};
        
        cleancombo = new JComboBox(cleanOption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        
        
        JLabel lbprice = new JLabel("Price");
        lbprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbprice.setBounds(60,230,120,30);
        add( lbprice);
         
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        
        JLabel lbtype = new JLabel(" Bed Type");
        lbtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbtype.setBounds(60,280,120,30);
        add( lbtype);
        
        
        String typeOption[] = {"Single Bed","Double Bed"};
        
        typecombo = new JComboBox(typeOption);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
        
        
        add = new JButton ("Add Rooms");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        
        add(add);
        
        
        cancel = new JButton ("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
       
        add(cancel);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/twel.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(200,100,940,470);
        setVisible(true);
        
        
    }
    
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == add){
              
                String roomnumber = tfroom.getText();
                String availability =(String) availablecombo.getSelectedItem();
                String status = (String) cleancombo.getSelectedItem();
                String price = tfprice.getText();
                String type = (String ) typecombo.getSelectedItem();
                
               try{
                   conn conn = new conn();
                   String str = "insert into room values('"+roomnumber+"' , '"+availability+"' , '"+status+"' , '"+price+"' ,'"+type+"')";
                   
                   conn.s.executeUpdate(str);
                   
                   JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                   
                   setVisible(false);
                   
                   
               }catch(Exception e){
                   
                   e.printStackTrace();
               }
                
                
          }else{
              setVisible(false);
          }
      }
    
    
    public static void main(String[] args){
        new AddRooms();
    }

    
    

}
