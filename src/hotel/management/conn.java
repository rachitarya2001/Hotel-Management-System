
package hotel.management;

import java.sql.*;

public class conn {
    
    Connection c;
    
    Statement s;
   
    conn() {
        
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
              c = DriverManager.getConnection("jdbc:mysql:///hotelmanagement", "root","123"); 
              s = c.createStatement();
        
        
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
}
