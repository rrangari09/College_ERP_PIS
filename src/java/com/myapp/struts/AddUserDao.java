/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author RohanShweta
 */
public class AddUserDao {
    Connection con1;
    PreparedStatement pst;
    //ResultSet rs;
    
    int getLoginDetails(HashMap usersMap)
    {
        int count=0;
    //HashMap<String,String> loginMap=new  HashMap<String,String>();
    // System.out.println(userid);
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst=con1.prepareStatement("insert into College_ERP_Users(User_name,User_EmailID,User_password,User_MobileNO,User_DOB,User_Gender,User_BloodGrp,User_AadharNo,User_Address_lane,User_Address_City,User_Address_State,User_Address_Country,User_Role)values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
    pst.setString(1,String.valueOf(usersMap.get("UserName")) );
    pst.setString(2,String.valueOf(usersMap.get("EmailId")) );
    pst.setString(3,String.valueOf(usersMap.get("Password")) );
    pst.setLong(4,Long.valueOf(String.valueOf(usersMap.get("MobileNo"))));
    pst.setDate(5,Date.valueOf(String.valueOf(usersMap.get("Dob"))));
    pst.setString(6,String.valueOf(usersMap.get("Gender")) );
    pst.setString(7,String.valueOf(usersMap.get("BloodGrp")) );
    pst.setLong(8,Long.valueOf(String.valueOf(usersMap.get("Aadhar"))));
    pst.setString(9,String.valueOf(usersMap.get("Lane")) );
    pst.setString(10,String.valueOf(usersMap.get("City")) );
    pst.setString(11,String.valueOf(usersMap.get("State")) );
    pst.setString(12,String.valueOf(usersMap.get("Country")) );
    pst.setInt(13,Integer.valueOf(String.valueOf(usersMap.get("Role"))) );

    
    System.out.println("Query is"+pst.toString());
     
    count=pst.executeUpdate();

    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
    return count;
    }
  
    
}
