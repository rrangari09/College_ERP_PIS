/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

/**
 *
 * @author RohanShweta
 */
import java.sql.*;
import java.util.ArrayList;
public class AddSubjectDao {
    Connection con1;
    PreparedStatement pst;
    int records=0;
   
    int addSubject(ArrayList subject_data){
        
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst=con1.prepareStatement("insert into coll_subject(sub_name,sub_credit,sub_branch,sub_level,total_marks,taught_by) values(?,?,?,?,?,?);");
    pst.setString(1,String.valueOf(subject_data.get(0)));
    pst.setInt(2,Integer.valueOf(String.valueOf(subject_data.get(1))));
    pst.setString(3,String.valueOf(subject_data.get(2)));
    pst.setString(4,String.valueOf(subject_data.get(3)));
    pst.setFloat(5,Float.valueOf(String.valueOf(subject_data.get(4))));
    pst.setInt(6,Integer.valueOf(String.valueOf(subject_data.get(5))));

    System.out.println("Query is"+pst.toString());
    records=pst.executeUpdate();
    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }

    return records;
    }
}
