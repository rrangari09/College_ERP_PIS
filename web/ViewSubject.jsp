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
        <h1>View Subjects</h1>
        <html:form action="SubDelete">
        <%
        try{
        ArrayList list=(ArrayList)request.getAttribute("Subject_List");
        if(list!=null){
        HashMap subjects=null;
        if(list!=null){%>
                  <table border ="1" width="500" align="center"> 
                    <tr bgcolor="00FF7F"> 
           <th><b>Select</b></th>               
          <th><b>Subject ID</b></th> 
          <th><b>Subject Name</b></th> 
          <th><b>Subject Credits</b></th> 
          <th><b>Subject Branch</b></th> 
          <th><b>Subject Eligible</b></th> 
         </tr>  
                      <% 
           for(int i=0;i<list.size();i++)
           {
               subjects=(HashMap)list.get(i);
                 %>
            <tr> 
                <td><input type="checkbox" name="subjects" value=<%=subjects.get("sub_id")%>></td>
                <td><%=subjects.get("sub_id")%></td> 
                <td><%=subjects.get("sub_name")%></td> 
                <td><%=subjects.get("sub_credit")%></td>
                <td><%=subjects.get("sub_branch")%></td>
                <td><%=subjects.get("sub_level")%></td>
            </tr>
                 <%
                 
           }
         %>  </table>  <%
        }
          request.setAttribute("Subject_List",null); 
        }
        else{
        %>
        <p>No Subject to show </p>
        <%
        }
        }catch(Exception e)
        {
          System.out.println(e);
        }
        
        %>
        
       <br/> 
       <br/>
         
            <html:submit value="Delete Subject"/> 
         
        </html:form>
       
       
  <%
                    try{
                    HttpSession hs=request.getSession(true);
                    System.out.println("Deleted_Sub_Count"+hs.getAttribute("Deleted_Sub_Count"));
                    if((hs.getAttribute("Deleted_Sub_Count"))!=null){
                    //int count= Integer.getInteger(String.valueOf(hs.getAttribute("Deleted_Sub_Count")));  
                    //System.out.println("Deleted_Sub_Count"+count);

                  
                    %>
                    
                     <p>Number of Subjects deleted is/are <%=hs.getAttribute("Deleted_Sub_Count")%>.</p>
                    
                     <%  
                    hs.setAttribute("Deleted_Sub_Count",null);
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
