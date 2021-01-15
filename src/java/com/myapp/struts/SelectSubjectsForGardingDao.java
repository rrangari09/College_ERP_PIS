/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author RohanShweta
 */
public class SelectSubjectsForGardingDao {
 Connection con1;
 PreparedStatement pst;
 ResultSet rs;
 ArrayList subject_for_grading=null;
 HashMap<Integer,String> subjects=null;
 
 ArrayList subjects_grading(int user_id){
 try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst=con1.prepareStatement("select sub_id,sub_name from coll_subject where taught_by=?;");
    pst.setInt(1,user_id);
    System.out.println("Query is"+pst.toString());
    rs=pst.executeQuery();
    subject_for_grading=new ArrayList();
    while(rs.next())
    {
        subjects=new HashMap<Integer,String>();
        subjects.put(rs.getInt("sub_id"),rs.getString("sub_name"));
        subject_for_grading.add(subjects);
    }
    rs.close();
    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
   
 return subject_for_grading;
 }
       
}
