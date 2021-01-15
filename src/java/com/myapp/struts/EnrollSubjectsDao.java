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
public class EnrollSubjectsDao {
 Connection con1,con2,con3;
 PreparedStatement pst,pst2,ps3;
 ResultSet rs,rs2,rs3;
 HashMap<Integer,String> subject_map=null;
 ArrayList available_sub=new ArrayList();
 String branch_name=null,degree_name=null;
 ArrayList<Integer> already_enrolled=new ArrayList<Integer>();
   
 ArrayList subjects_available(String UserID){
   String rollno=null;  
   try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null || con2==null || con3==null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst=con1.prepareStatement("select branch,degree,rollno from college_erp_students where student_id=?;");
    pst.setInt(1,Integer.valueOf(UserID));
    System.out.println("Query is"+pst.toString());
    rs=pst.executeQuery();
    while(rs.next())
    {
        branch_name=rs.getString("branch");
        degree_name=rs.getString("degree");
        rollno=String.valueOf(rs.getInt("rollno"));
    }
    
    ps3=con3.prepareStatement("select sub_id from subject_enrolled where roll_no=?;");
    ps3.setInt(1,Integer.valueOf(rollno) );
    rs3=ps3.executeQuery();
    while(rs3.next()){
    already_enrolled.add(rs3.getInt("sub_id"));
    }
    
    
    
    if(branch_name!=null && degree_name !=null){
    pst2=con2.prepareStatement("select sub_id,sub_name from coll_subject where sub_branch=? and sub_level=?;");
    pst2.setString(1,branch_name);
    pst2.setString(2,degree_name);
    System.out.println("Query is"+pst2.toString());
    rs2=pst2.executeQuery();
    while(rs2.next()){
       subject_map=new HashMap<Integer,String>();
       if(!already_enrolled.contains(rs2.getInt("sub_id")))
       { subject_map.put(rs2.getInt("sub_id"), rs2.getString("sub_name"));
          available_sub.add(subject_map);}
    }
    }    
    rs.close();
    rs2.close();
    rs3.close();
    pst.close();
    pst2.close();
    ps3.close();
    con1.close();
    con2.close();
    con3.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
  
 
 return available_sub;
 }  
 
 
 int enroll_subjects(ArrayList<Integer> ids,int userid){
 int count=0;
 try{
     int rollnumber=0;
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    if(con1 == null || con2 ==null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    
    pst2=con2.prepareStatement("select rollno from college_erp_students where student_id=?;");
    pst2.setInt(1,userid);
    rs2=pst2.executeQuery();
    while(rs2.next())
    {
    rollnumber=rs2.getInt("rollno");
    }
    pst=con1.prepareStatement("insert into subject_enrolled(roll_no,sub_id)values(?,?);");

    
    for(int i=0;i<ids.size();i++){
    pst.setInt(1,rollnumber);
    pst.setInt(2,Integer.valueOf(String.valueOf(ids.get(i))));
    System.out.println("Query for enrolled subject is "+pst.toString());
    count+=pst.executeUpdate();
    }
    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
 
 
 
 return count;
 }
}
