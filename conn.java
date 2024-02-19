
///this is for connection class for connect the database 


package bank.management.system;
import java.sql.*;
import java.sql.Connection;

public class conn {
    Connection c; //class which is declair global
    Statement s;//create new 
        public conn(){
            try{
               
                
//                c=DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","Viratverma@12");
                c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root","Viratverma@12");
                System.out.println("Database connection established successfully");
                s=c.createStatement();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e);
            }
}
}

