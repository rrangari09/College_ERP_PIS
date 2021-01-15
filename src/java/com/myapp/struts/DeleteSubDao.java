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
public class DeleteSubDao {
    Connection con1;
    PreparedStatement pst1;
    int count=0;
    
    int deletesubject(ArrayList ids){
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst1=con1.prepareStatement("delete from coll_subject where sub_id=?;");
    for(int i=0;i<ids.size();i++){
    pst1.setInt(1,Integer.valueOf(String.valueOf(ids.get(i))));
    System.out.println("Query is"+pst1.toString());
    count+=pst1.executeUpdate();
    }
    pst1.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
    
    return count;
    }
    
}
