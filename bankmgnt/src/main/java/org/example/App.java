package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
       String url="jdbc:mysql://localhost:3306/bnkmngt";
       String username="root";
       String password="Viratverma@12";

       try{
           Connection connection=DriverManager.getConnection(url,username, password);
           Statement statement = connection.createStatement();
           System.out.println("Connection establish successfully");

           Scanner sc=new Scanner(System.in);
           System.out.println("Fatch data- press 1 : or insert data - press 2:");
           int choice=sc.nextInt();
           switch (choice){
               case 1 :
                   ResultSet resultSet =statement.executeQuery("select * from student ");
                   operation.fatchData(resultSet);
//                   operation.fatchData(fatchData);
                   break;
               case 2:
                   ResultSet maxRollresset=statement.executeQuery("select max(roll) as maxRoll from student");
                   int max_roll=0;
                   while(maxRollresset.next()) {
                       max_roll = maxRollresset.getInt("maxRoll");
                       System.out.println("max roll no:" + max_roll);
//                   } // yha toh yahi pr whle lop terminate kar do warna last me break lga do

                       //update the max_roll because if roll is not primary key
                       System.out.println("Enter your roll");
                       String roll=sc.next();
                       System.out.println("Enter your Name");
                       String name=sc.next();
                       System.out.println("Enter you age");
                       String age=sc.next();
                       int rowCount=statement.executeUpdate("insert into student values("+roll+",'"+name+"',"+age+")");
                       if(rowCount>0) {
                           System.out.println("Data inserted successfully");
                       }
                       break; //this is for terminated while loop
                   }
                    break;

               case 4:
                   System.out.println("Enter roll for delete the data");
                   int id=sc.nextInt();
                   int var=statement.executeUpdate("Delete from Student where roll ="+ id);
                   if(var>0){
                       System.out.println("Data is deleted:"+ id);
                   }
                   else{
                       System.out.println("Data is not deleted:");
                   }

               default:
                   System.out.println("Enter valid number");
                   break;
           }



       }
       catch (Exception e){
        e.printStackTrace();
       }
    }
}
