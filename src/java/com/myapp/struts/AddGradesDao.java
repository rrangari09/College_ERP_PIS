/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author RohanShweta
 */
public class AddGradesDao {
    
    Connection con1;
    PreparedStatement pst;
    
    int addgrades(String sub_id,ArrayList id_list,String[] marks){
    int count=0;
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    for(int i=0;i<marks.length;i++){
    pst=con1.prepareStatement("update subject_enrolled set marks_secured=? where roll_no=? and sub_id=?;");
    pst.setFloat(1,Float.valueOf(marks[i]));
    pst.setInt(2,Integer.valueOf(String.valueOf(id_list.get(i))));
    pst.setInt(3,Integer.valueOf(sub_id));
    System.out.println("Query is "+pst.toString());
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
