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
        <h1>Hello World! Admin</h1>
        
        <br/><br/><br/>
        <form method="post" action="">
            <input type="submit" value="Generate ID Cards">
        </form>
        
        <br/><br/><br/>
        
        
        <a href="AddSubject.jsp">  <input type="button" value="Add Subject"></a>
        <br/>
        
        <html:form action="ViewSub">
            <html:submit value="View Subjects"/> 
         
        </html:form>
        <br/>
         <html:form action="AllUsers">
            <html:submit value="View Users List"/> 
         
        </html:form>
        
         <br/>
         <html:form action="AllUsers">
            <html:submit value="View Users "/> 
         
        </html:form>
        <br/>
        
         <html:form action="AvailableSub">
            <html:submit value="Enroll Into Courses"/> 
         
        </html:form>
        <br/>
        <br/>
        <html:form action="SubjectGrading">
            <html:submit value="Select Subject for Grading"/> 
         
        </html:form>
        
        <a href="GenerateNotice.jsp"><p>Generate Notice</p></a>
        <br/>    
        <br/>
        <html:form action="DoLogout">
            <html:submit value="Log Out"/> 
         
        </html:form>
    </body>
</html>
