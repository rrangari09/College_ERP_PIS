<%-- 
    Document   : AddSubject
    Created on : Dec 23, 2020, 4:01:20 PM
    Author     : RohanShweta 
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import = "java.io.*,java.util.*,javax.servlet.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Users</title>
    </head>
    <body style="background-color: white">
         <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        %>
        <h1>Hello World!  Add Users</h1>
        <br/><br/>
        <br/>
        <html:form action="UserAddition">
            <table cellspacing="15">
                <tr>
                    <td>Username: </td>
                    <td>
                        <html:text  property="u_name"/>
                    </td>
                </tr>
                <tr>
                    <td>EmailId: </td>
                    <td>
                        <html:text  property="emailid"/>
                    </td>
                </tr>
                   <tr>
                    <td>Password: </td>
                    <td>
                        <html:text  property="password"/>
                    </td>
                </tr>
                   <tr>
                    <td>Mobile Number: </td>
                    <td>
                    <html:text  property="u_mobile"/>
                    </td>
                </tr>
                   <tr>
                   <td>Date Of Birth: </td>
                    <td>
                        <html:text property="dob"/>
                    </td>
                </tr>
                
                  <tr>
                    <td>Gender:</td>
                    <td>
                       Male <html:radio  value="male" property="gender"/>
                       Female <html:radio value="female"   property="gender"/>
                       Other <html:radio value="other"  property="gender"/>
                    </td>
                </tr>
                
                  <tr>
                    <td>Bloodgroup: </td>
                    <td>
                        <html:select  property="bloodgrp">
                            <option value="A+"> A+ </option>
                            <option value="A-"> A- </option>
                            <option value="B+"> B+ </option>
                            <option value="B-"> B- </option>
                            <option value="AB+"> AB+ </option>
                            <option value="AB-"> AB- </option>
                            <option value="O+"> O+ </option>
                            <option value="O-"> O- </option>                          
                        </html:select>    
                        
                    </td>
                </tr>
                
                 <tr>
                    <td>Aadhar Number: </td>
                    <td>
                        <html:text  property="aadhar"/>
                    </td>
                </tr>
                
                   <tr>
                    <td>Address Lane: </td>
                    <td>
                        <html:text  property="lane"/>
                    </td>
                </tr>
                
                   <tr>
                    <td>City: </td>
                    <td>
                        <html:text  property="city"/>
                    </td>
                </tr>
                
                   <tr>
                    <td>State: </td>
                    <td>
                        <html:text  property="state"/>
                    </td>
                </tr>
                
                   <tr>
                    <td>Country: </td>
                    <td>
                        <html:text  property="country"/>
                    </td>
                </tr>
                
                  <tr>
                    <td>Role: </td>
                    <td>
                       Admin <html:radio  value="1" property="role"/>
                       Faculty <html:radio value="2"   property="role"/>
                       Student <html:radio value="3"  property="role"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <html:submit value="Add User"/>                             
                    </td>                   
                </tr>
            </table>
        </html:form>
        
        <br/>
        <br/>
       <%
                    try{
                    HttpSession hs=request.getSession(true);
                    
                    if((hs.getAttribute("SubjectAdd_status"))!=null){
                    if(hs.getAttribute("SubjectAdd_status").equals("true"))
                    {
                        %><p>Subject Added Successfully</p>
                     <%}else{
                        %><p>Subject not Added</p><%
                    }  
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
           
           <%
                   HttpSession hs=request.getSession(true);
                   String user_addition=String.valueOf(hs.getAttribute("User_addition_status"));
                   if(hs.getAttribute("User_addition_status")!=null)
                   {
                     if(user_addition.equals("true"))
                     {
                     %>
                     <p>User Added Successfully !</p>
                     
           <%
                     
                         
                   }else{
                         
                      %>
                      <p>Problem while adding User ! </p>
                   <%   
                     }
                     hs.setAttribute("User_addition_status",null);
                   }
           %>
    </body>
</html>
