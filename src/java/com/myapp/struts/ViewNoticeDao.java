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
public class ViewNoticeDao {
    
    Connection con1;
    PreparedStatement pst;
    ResultSet rs;
    
    ArrayList getNoticeDetails(int roleid)
    {
    ArrayList notices=new ArrayList();    
    HashMap<String,String> noticemap;
    // System.out.println(userid);
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/college_erp?user=root&password=advik&useSSL=false");
    
    if(con1 == null)
      {
        throw new NullPointerException ("Connection object is not initialised properly");
      }
    
    pst=con1.prepareStatement("select notice_subject,notice_data from notices where creator_role_id <= ?;");
    pst.setInt(1, roleid);
    System.out.println("Query in view notice dao is"+pst.toString());
    rs=pst.executeQuery();
    while(rs.next())
    {
        noticemap=new HashMap();
        noticemap.put("Subject",rs.getString("notice_subject"));
        noticemap.put("Body",rs.getString("notice_data"));
        notices.add(noticemap);
    }
    rs.close();
    pst.close();
    con1.close();
    }catch(Exception e)
    {
    System.out.println(e);
    }
    return notices;
    }
    
    
}
