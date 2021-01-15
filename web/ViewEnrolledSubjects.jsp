<%-- 
    Document   : ViewEnrolledSubjects
    Created on : Jan 6, 2021, 10:16:59 AM
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
        <% 
         try{
         ArrayList enrolled_list=(ArrayList)request.getAttribute("Enrolled_sub_info");
         HashMap enrolled_sub=null;
          if(enrolled_list!=null || enrolled_list.size()>0){
          %>
           <h1>Enrolled Subjects by You is/are</h1>
           <br/>
           <br/>
            <table border ="1" width="500" align="center"> 
                    <tr bgcolor="00FF7F"> 
          <th><b>Subject Name</b></th>
          <th><b>Branch</b></th>
          <th><b>Total Marks Alloted</b></th>
         </tr>  
         <%
          for(int i=0;i<enrolled_list.size();i++){
          enrolled_sub=(HashMap)enrolled_list.get(i);
          
          %>
         
       <tr>
           <td><%=enrolled_sub.get("sub_name")%></td>
           <td><%=enrolled_sub.get("sub_branch")%></td>
           <td><%=enrolled_sub.get("total_marks")%></td>
           
       </tr>   
         
          <br/>
          <%
          }
          %>         </table>
<%
          request.setAttribute("Enrolled_sub_info", null);
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
