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
        <h1>Select Subject to Add Grades</h1>
        <br/>
        <br/>
      <html:form action="StudentForGrades">
        <Subjects Available For you.>
        <%
        try{
        ArrayList sub_list=(ArrayList)request.getAttribute("gradingsublist");
        HashMap subjects=null;
        Set<Integer> hash_Set= new HashSet<Integer>(); 
        int id;
 
        if(sub_list!=null){%>
                  <table border ="1" width="500" align="center"> 
                    <tr bgcolor="00FF7F"> 
          <th><b>Select</b></th>
          <th><b>Subjects Name</b></th>
         </tr>  
                      <% 
            
           for(int i=0;i<sub_list.size();i++)
           {
               subjects=(HashMap)sub_list.get(i);
               hash_Set=subjects.keySet();
               id=hash_Set.iterator().next();
                 %>
            <tr> 
                <td><input type="radio" name="subjects_for_grades" value=<%=id%>></td>
               <td><%=subjects.get(id)%></td>
            </tr>
                 <%
                 
           }
         %>  </table>  <%
          request.setAttribute("AvailableSubList",null); 
        }
        else{
        %>
        <p>No Subject is available Grading.</p>
        <%
        }
        }catch(Exception e)
        {
          System.out.println(e);
        }
        
        %>
        
         <html:submit value="Add Grades"/>
        </html:form>
        <br/> 
        
        <br/>
        <html:form action="DoLogout">
            <html:submit value="Log Out"/> 
         
        </html:form>
    </body>
</html>
