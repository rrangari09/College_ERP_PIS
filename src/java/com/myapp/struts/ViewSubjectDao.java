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
public class ViewSubjectDao {
    Connection con1;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList subjects=null;
    HashMap subjectmap=null;
    ArrayList viewSubject(){
    try{
                System.out.println("Inside view Subject action");

    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst=con1.prepareStatement("select * from coll_subject;");
    System.out.println("Query is"+pst.toString());
    rs=pst.executeQuery();
    subjects=new ArrayList();
    while(rs.next())
    {
      subjectmap=new HashMap();   
      System.out.println("Sub name is"+rs.getString("sub_name"));
      subjectmap.put("sub_id",String.valueOf(rs.getInt("sub_id")));
      subjectmap.put("sub_name",rs.getString("sub_name"));
      subjectmap.put("sub_credit",String.valueOf(rs.getInt("sub_credit")));
      subjectmap.put("sub_branch",rs.getString("sub_branch"));
      subjectmap.put("sub_level",rs.getString("sub_level"));
      subjects.add(subjectmap);
    }
    rs.close();
    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
    
    return subjects;
    }
    
}
