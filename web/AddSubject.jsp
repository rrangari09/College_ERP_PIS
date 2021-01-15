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
        <title>JSP Page</title>
    </head>
    <body style="background-color: white">
         <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        %>
        <h1>Hello World!  Add Subjects</h1>
        <br/><br/>
        <br/>
        <html:form action="AddSub">
            <table cellspacing="15">
                <tr>
                    <td>SubjectName: </td>
                    <td>
                        <html:text  property="sub_name"/>
                    </td>
                </tr>
                <tr>
                    <td>Subject Credits: </td>
                    <td>
                        <html:text  property="sub_cred"/>
                    </td>
                </tr>
                
                  <tr>
                    <td>Subject Branch :</td>
                    <td>
                        <html:text   property="sub_branch"/>
                    </td>
                </tr>
                
                  <tr>
                    <td>Subject Level: </td>
                    <td>
                        <html:text  property="sub_level"/>
                    </td>
                </tr>
                
                 <tr>
                    <td>Total Marks: </td>
                    <td>
                        <html:text  property="sub_marks"/>
                    </td>
                </tr>
                
                  <tr>
                    <td>Subject Taught by: </td>
                    <td>
                        <html:text  property="sub_taught"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <html:submit value="Submit"/>                             
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
    </body>
</html>
