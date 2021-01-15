/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author RohanShweta
 */
public class ViewUserDao {
    Connection con1;
    Connection con2;
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    ResultSet rs2;
    HashMap<String,String> UsersMap=null;
    ArrayList userslist=null;
    HashMap<Integer, String> role_map=null;
    int roleid=0;
    
    ArrayList ViewUsersData()
    {
       
    //System.out.println(userid);
    try{
    System.out.println("Inside View Users Dao");
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null || con2 ==null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst=con1.prepareStatement("select User_name,User_EmailID,User_ID,User_MobileNO,User_DOB,User_Gender,User_BloodGrp,User_AadharNo,User_Address_lane,User_Address_City,User_Address_State,User_Role,User_Address_Country from College_ERP_Users;");
    System.out.println("Query is"+pst.toString());
    rs=pst.executeQuery();
    userslist=new ArrayList();
    pst2=con2.prepareStatement("select * from college_erp_rolls;");
    rs2=pst2.executeQuery();
    role_map=new HashMap<Integer,String>();
    while(rs2.next())
    {
       role_map.put((Integer)rs2.getInt("rollid"),rs2.getString("rollname"));
    }
    while(rs.next())
    {
        UsersMap=new  HashMap<String,String>();
        UsersMap.put("user_name",rs.getString("User_name"));
        UsersMap.put("mail_id",rs.getString("User_EmailID"));
        UsersMap.put("user_id",String.valueOf(rs.getInt("User_ID")));
        UsersMap.put("mobile_num",String.valueOf(rs.getLong("User_MobileNO")));
        UsersMap.put("date_of_birth",String.valueOf(rs.getDate("User_DOB"))); 
        UsersMap.put("gender",rs.getString("User_Gender"));
        UsersMap.put("bloodgrp",rs.getString("User_BloodGrp"));
        UsersMap.put("adhar_no",String.valueOf(rs.getLong("User_AadharNo")));
        UsersMap.put("address_lane",rs.getString("User_Address_lane"));
        UsersMap.put("address_city",rs.getString("User_Address_City"));
        UsersMap.put("address_state",rs.getString("User_Address_State"));
        UsersMap.put("address_country",rs.getString("User_Address_Country"));
        roleid=rs.getInt("User_Role");
        UsersMap.put("role",role_map.get(roleid));
        System.out.println("Succefully map filled");
        userslist.add(UsersMap);
    }
    rs.close();
    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
    return userslist;
    }
    
}
