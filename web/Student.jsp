<%-- 
    Document   : Admin
    Created on : Dec 12, 2020, 11:00:48 PM
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
        <title>Student</title>
    </head>
    <body>
         <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        %>
        <h1>Hello World! Student</h1>
        
        <br/><br/><br/>
       <!--<form method="post" action="">
            <input type="submit" value="Generate ID Cards">
        </form>
        
        <br/><br/><br/>-->
        
        
       
 
        <br/>
    
        
  
        <br/>
        
         <html:form action="AvailableSub">
            <html:submit value="Enroll Into Courses"/> 
         
        </html:form>
        <br/>
        
        
          <html:form action="enrolled_sub_view">
            <html:submit value="Enrolled Subjects"/> 
         
        </html:form>
        <br/>
        
        
        <a href="GenerateNotice.jsp"><p>Generate Notice</p></a>
        <br/>  
        
        <br/>
        <%
        try{
         ArrayList notice_list=(ArrayList)request.getAttribute("Notices");
         HashMap notice_map=null;
          if(notice_list!=null || notice_list.size()>0){
          for(int i=0;i<notice_list.size();i++){
          notice_map=(HashMap)notice_list.get(i);
          
          %>
          <p><h3><%=notice_map.get("Subject")%></h3> </p>
          <p><%=notice_map.get("Body")%> </p>
          <br/>
          <%
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
