/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author RohanShweta
 */
public class SelectStudentForGradingDao {
    Connection con1,con2;
    PreparedStatement pst,pst2;
    ResultSet rs,rs2;
    
    
    ArrayList getStudentslistForGarding(int subid){
    
    HashMap<String,String> studentmap=null;
    HashMap<String,String> studentids= new HashMap();  
    Set<String> hash_Set= new HashSet<String>(); 
    ArrayList studentmarks=new ArrayList();

    try{
   
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null || con2==null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst2=con2.prepareStatement("select roll_no,marks_secured from subject_enrolled where sub_id=?");
    pst2.setInt(1, subid);
    System.out.println("Query 1 is"+pst2.toString());
    rs2=pst2.executeQuery();
    while(rs2.next()){
    studentids.put(String.valueOf(rs2.getInt("roll_no")),String.valueOf(rs2.getFloat("marks_secured")));
    }
        System.err.println("Studentid map is "+studentids);
    hash_Set=studentids.keySet();
    ArrayList idlist=new ArrayList(hash_Set);

    System.out.println("hashset is"+hash_Set);
    
    pst=con1.prepareStatement("select rollno,student_name,branch,current_year,degree from college_erp_students where rollno=? ;");
    for(int i=0;i<studentids.size();i++){
    String id=String.valueOf(idlist.get(i));
    pst.setInt(1,Integer.valueOf(id));
    System.out.println("Query 2 is "+pst.toString());
    rs=pst.executeQuery();
    if(studentids.size()!=0){
    while(rs.next()){
    studentmap=new HashMap<String,String>();
    studentmap.put("RollNo",String.valueOf(rs.getInt("rollno")));
    studentmap.put("Name",rs.getString("student_name"));
    studentmap.put("branch",rs.getString("branch"));
    studentmap.put("Current_year",String.valueOf(rs.getInt("current_year")));
    studentmap.put("Degree",rs.getString("degree"));
    studentmap.put("Marks",studentids.get(id));
    studentmap.put("Subjectid",String.valueOf(subid));
    studentmarks.add(studentmap);
    }
    
    }
    
    }
    System.err.println("studentmarks map is"+studentmarks);
    rs.close();
    rs2.close();
    pst.close();
    pst2.close();
    con1.close();
    con2.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
   
    return studentmarks; 
    }
}
