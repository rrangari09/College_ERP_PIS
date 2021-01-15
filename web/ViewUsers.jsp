<%-- 
    Document   : ViewSubject
    Created on : Dec 24, 2020, 12:08:43 AM
    Author     : RohanShweta 
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import = "java.io.*,java.util.*,javax.servlet.*,org.apache.struts.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        %>
        <h1>View Users List</h1>
        
        <%
        try{
        ArrayList users_list=(ArrayList)request.getAttribute("Users_list");
        HashMap users=null;
        if(users_list!=null || users_list.size()>0){%>
                  <table border ="1" width="500" align="center"> 
                    <tr bgcolor="00FF7F"> 
          <th><b>User ID</b></th> 
          <th><b>User Name</b></th> 
          <th><b>Email ID</b></th> 
          <th><b>Mobile Number</b></th> 
          <th><b>Date Of Birth</b></th> 
          <th><b>Gender</b></th> 
          <th><b>Blood Group</b></th>
          <th><b>Aadhar Number</b></th>
          <th><b>Address</b></th>
          <th><b>Role</b></th> 
         </tr>  
                      <% 
           for(int i=0;i<users_list.size();i++)
           {
               users=(HashMap)users_list.get(i);
                 %>
            <tr> 
               <td><%=users.get("user_id")%></td>
                <td><%=users.get("user_name")%></td> 
                <td><%=users.get("mail_id")%></td> 
                <td><%=users.get("mobile_num")%></td>
                <td><%=users.get("date_of_birth")%></td>
                <td><%=users.get("gender")%></td>
                <td><%=users.get("bloodgrp")%></td>
                <td><%=users.get("adhar_no")%></td>
                <td><%=users.get("address_lane")%>
                    <p><%=users.get("address_city")%></p>
                    <p><%=users.get("address_state")%></p>
                    <p><%=users.get("address_country")%></p>
                 </td>
                <td><%=users.get("role")%></td>
            </tr>
                 <%
                 
           }
         %>  </table>  <%
          request.setAttribute("UsersList",null); 
        }
        }catch(Exception e)
        {
          System.out.println(e);
        }
        
        %>
        
        <br/>
        <html:form action="DoLogout">
            <html:submit value="Log Out"/> 
         
        </html:form>
    </body>
</html>
