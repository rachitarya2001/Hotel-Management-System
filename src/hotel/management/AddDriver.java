
package hotel.management;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JButton add, cancel;
    JTextField tfname , tfcompany,tfage , tfmodel , tflocation;
    JComboBox typcombo, availablecombo, agecombo , cleancombo , gendercombo;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);
        
        JLabel lbrommno = new JLabel(" Name");
        lbrommno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbrommno.setBounds(55,70,120,30);
        add( lbrommno);
         
        
        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);
        
        
        JLabel lbage = new JLabel(" Age");
        lbage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbage.setBounds(55,110,120,30);
        add( lbage);
        
        
        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);
        
        
        
        JLabel lbclean = new JLabel(" Gender");
        lbclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbclean.setBounds(55,150,120,30);
        add( lbclean);
        
        
        String cleanOption[] = {"Male","Female"};
        
        gendercombo = new JComboBox(cleanOption);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        
        
        JLabel lbprice = new JLabel("Car Company");
        lbprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbprice.setBounds(60,190,120,30);
        add( lbprice);
         
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);
        
        
        JLabel lbtype = new JLabel("Car Model");
        lbtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbtype.setBounds(60,230,120,30);
        add( lbtype);
        
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);
        
        JLabel lbavailable = new JLabel("Availability");
        lbavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbavailable.setBounds(60,270,120,30);
        add( lbavailable);
        
        String driverOptions[] = {"Available","Busy"};
        
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lblocation = new JLabel("Location");
        lblocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblocation.setBounds(60,310,120,30);
        add( lblocation);
        
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);
        
        
        add = new JButton ("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        
        add(add);
        
        
        cancel = new JButton ("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
       
        add(cancel);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/elv.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(150,100,990,470);
        setVisible(true);
        
        
    }
    
      public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == add){
              
                String name = tfname.getText();
                String age = tfage.getText();
                String gender = (String) gendercombo.getSelectedItem();
                String company = tfcompany.getText();
                String brand = tfmodel.getText();
                String available = (String) availablecombo.getSelectedItem();
                String location = tflocation.getText();
                
               try{
                   conn conn = new conn();
                   String str = "insert into drivers values('"+name+"' , '"+age+"' , '"+gender+"' , '"+company+"' , '"+brand+"' , '"+available+"' ,'"+location+"')";
                  
                   conn.s.executeUpdate(str);
                   
                   JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
                   
                   setVisible(false);
                   
                   
               }catch(Exception e){
                   
                   e.printStackTrace();
               }
                
                
          }else{
              setVisible(false);
          }
      }
    
    
    public static void main(String[] args){
        new AddDriver();
    }

    
    

}

