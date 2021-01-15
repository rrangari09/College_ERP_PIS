/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.util.HashMap;
import java.sql.*;

/**
 *
 * @author RohanShweta
 */
public class GenerateIDDAO {
    Connection con1,con2;
    PreparedStatement pst,pst2;
    ResultSet rs,rs2;
    int id1,id2;
    String role1,role2;
    
    HashMap<String,String> id_info=null;
    HashMap<String,String> generate_id(String user_email_id,int user_id){
    
    try{
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
      if(con1 == null || con2 ==null)
        {
          throw new NullPointerException ("Connection object is not initialised properly");
        }
    pst=con1.prepareStatement("select User_name,User_ID,User_EmailID,User_MobileNO,User_DOB,User_Gender,User_BloodGrp,User_Address_lane,User_Address_City,User_Address_State,User_Address_Country from College_ERP_Users where User_EmailID=?;");
    pst2=con2.prepareStatement("select rollno,branch,current_year,degree,student_id,user_role fromcollege_erp_students where student_id=?;");
    pst.setString(1, user_email_id);
    pst2.setInt(1, user_id);
    System.out.println("Query is"+pst.toString());
    System.out.println("Query is"+pst2.toString());
    rs=pst.executeQuery();
    rs2=pst2.executeQuery();
    if(rs!=null) {
       id1=rs.getInt("User_ID");
       role1=rs.getString("User_Role");
    }
    if(rs2!=null){
       id2=rs2.getInt("student_id");
       role2=rs2.getString("user_role");
    }
    while(rs.next() && id1==id2 && role1.equals(role2))
    {
        id_info.put("User_name",rs.getString("User_name"));
        id_info.put("User_EmailID",rs.getString("User_EmailID"));
        id_info.put("User_MobileNO",String.valueOf(rs.getInt("User_MobileNO")));
        id_info.put("User_DOB",String.valueOf(rs.getDate("User_DOB")));
        id_info.put("User_Gender",rs.getString("User_Gender"));
        id_info.put("User_BloodGrp",rs.getString("User_BloodGrp"));
        id_info.put("User_Address_lane",rs.getString("User_Address_lane"));
        id_info.put("User_Address_City",rs.getString("User_Address_City"));
        id_info.put("User_Address_Country",rs.getString("User_Address_Country"));
            
       // System.out.println("Succefully map filled");
    }
    while(rs2.next() && id1==id2 && role1.equals(role2)){
        id_info.put("rollno",String.valueOf(rs2.getInt("rollno")));
        id_info.put("branch",rs2.getString("branch"));
        id_info.put("current_year",String.valueOf(rs2.getInt("current_year")));
        id_info.put("branch",rs2.getString("branch"));
        id_info.put("degree",rs2.getString("degree"));
        
    }
    rs.close();
    rs2.close();
    pst.close();
    pst2.close();
    con1.close();
    con2.close();
   
    
        }
        catch(Exception e){
        System.out.println(e);
        }
        return id_info;
    
    }
}
