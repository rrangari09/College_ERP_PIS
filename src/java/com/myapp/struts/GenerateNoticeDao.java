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
import java.util.HashMap;

/**
 *
 * @author RohanShweta
 */
public class GenerateNoticeDao {
    
    Connection con1;
    PreparedStatement pst;
        int count=0;    

    
    int generateNotice(String userid, String roleid, String notice, String subject)
    {
   // HashMap<String,String> loginMap=new  HashMap<String,String>();
    // System.out.println(userid);
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    pst=con1.prepareStatement("insert into notices(notice_data,created_by,create_time,creator_role_id,notice_subject)values(?,?,now(),?,?);");
    pst.setString(1,notice);
    pst.setInt(2,Integer.valueOf(userid));
    pst.setInt(3, Integer.valueOf(roleid));
    pst.setString(4,subject);
    System.out.println("Query in NoticeGeneration Dao is"+pst.toString());
    count=pst.executeUpdate();
    
    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
    return count;
    }
    
}
