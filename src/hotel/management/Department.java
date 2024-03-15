
package hotel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Department(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        
                
        JLabel l1 = new JLabel("Department");
        l1.setBounds(180,10,100,20);
        add(l1);
        
        
        JLabel l2 = new JLabel("Budget ");
        l2.setBounds(420,10,100,20);
        add(l2);
        
       
        
        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        try{
            conn c = new conn();
            ResultSet rs  = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
        }catch(Exception e){
            e.printStackTrace();
                
            
        }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(300,450,120,30);
        add(back);
        
        
        
        setBounds(250,100,700,550);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
        
    }
    
    
    
    public static void main(String [] args){
        
        new Department();
    }
}
