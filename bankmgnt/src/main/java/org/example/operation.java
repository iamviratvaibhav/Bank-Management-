package org.example;

import java.sql.ResultSet;

public class operation {
    public static void fatchData(ResultSet resultSet) throws Exception{
        System.out.println("************** Your Data *******************");
        while(resultSet.next()){

            System.out.println("RollNO: "+resultSet.getInt("roll"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("age: "+ resultSet.getInt("age"));
            System.out.println("****************************");
        }
    }
}
