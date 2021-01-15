/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author RohanShweta
 */
public class ViewEnrolledSubjectsDao {
    Connection con1,con2,con3;
    PreparedStatement pst,pst2,pst3;
    ResultSet rs,rs2,rs3;
    
    ArrayList getEnrolledSubjects(int userid)
    {
    HashMap<String,String> enrolledsub_map=null;
    ArrayList subId=new ArrayList();
    ArrayList enrolled_sub=new ArrayList();
    int rollno=0;
    // System.out.println(userid);
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");

    if(con1 == null || con2 == null || con3 ==null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst=con1.prepareStatement("select rollno from college_erp_students where student_id=?;");
    pst.setInt(1, userid);
    System.out.println("Query 1 in View EnrolledSubject Dao is"+pst.toString());
    rs=pst.executeQuery();
    while(rs.next())
    {
      rollno=rs.getInt("rollno");
    }
        System.out.println("Roll No is "+rollno);
    pst2=con2.prepareStatement("select sub_id from subject_enrolled where roll_no=?;");
    pst2.setInt(1, rollno);
    System.out.println("Query  2 in View EnrolledSubject Dao is"+pst2.toString());
     rs2=pst2.executeQuery();
     while(rs2.next()){
     subId.add(rs2.getInt("sub_id"));
     }
     
     pst3=con3.prepareStatement("select sub_name,sub_branch,total_marks from coll_subject where sub_id=?;");
     if(subId.size()>0){
     for(int i=0;i<subId.size();i++){
     pst3.setInt(1,Integer.valueOf(String.valueOf(subId.get(i))));
     rs3=pst3.executeQuery();
     while(rs3.next()){
     enrolledsub_map=new HashMap();
     enrolledsub_map.put("sub_name", rs3.getString("sub_name"));
     enrolledsub_map.put("sub_branch", rs3.getString("sub_branch"));
     enrolledsub_map.put("total_marks",String.valueOf(rs3.getFloat("total_marks")));
     enrolled_sub.add(enrolledsub_map);
     }
     
     }
     
     }
     
    rs.close();
    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
    return enrolled_sub;
    }
    
    
}
