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
        <h1>Add Grades for students</h1>
        <br/>
        <br/>
      <html:form action="GradesAddition">
        <%
        try{
        HttpSession hs=request.getSession(true);
        ArrayList students_list=(ArrayList)request.getAttribute("StudentsForGrading");
        HashMap students=null;
        ArrayList id_list=new ArrayList();
        String marks;
 
 
        if(students_list!=null){%>
                  <table border ="1" width="500" align="center"> 
                    <tr bgcolor="00FF7F"> 
          <th><b>Roll Number</b></th>
          <th><b>Name</b></th>
          <th><b>Branch</b></th>
          <th><b>Current year</b></th>
          <th><b>Degree</b></th>
          <th><b>Marks</b></th>

         </tr>  
                      <% 
            
           for(int i=0;i<students_list.size();i++)
           {
               students=(HashMap)students_list.get(i);
               id_list.add(students.get("RollNo"));
                 %>
            <tr> 
               <td><%=students.get("RollNo")%></td>
               <td><%=students.get("Name")%></td>
               <td><%=students.get("branch")%></td>
               <td><%=students.get("Current_year")%></td>
               <td><%=students.get("Degree")%></td>
            <td><input type="text" name="marks" placeholder="<%=students.get("Marks")%>" value="<%=students.get("Marks")%>"></td>
            </tr>
                 <%
                 
           }
         %>  </table>  <%
          request.setAttribute("StudentsForGrading",null); 
          hs.setAttribute("studentids",id_list);
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
      <%
      try{
      HttpSession hs=request.getSession(true);
      if((hs.getAttribute("UpdatedMarksCount")!=null))
      {
       String count=String.valueOf(hs.getAttribute("UpdatedMarksCount"));
       %>
       <p>Students marks updated </p>
       <%
       hs.setAttribute("UpdatedMarksCount",null);
      }
      }
      catch(Exception e)
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
