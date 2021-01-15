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
        <title>Admin</title>
      <style>
         body{
            font-family: sans-serif;
         }
         *{
             box-sizing: border-box;
         }
         .backgimg{
            position: fixed;
           display: block;
           background-image: url("background.jpg");
           filter: blur(2px);
           -webkit-filter: blur(2px);
           width: 1500px;
           height: 900px;
           background-repeat: no-repeat;
           background-size:cover;
         }
         .holder{
            padding: 16px;
           background-color: white;
           margin: 50px 350px 350px 350px;
           border-radius: 15px;
           border-color: whitesmoke;
           position:absolute;
           width: 35%;
           height: 80%;
         }
         input[type=text],input[type=password]{
            width: 100%;
           height: 5px;
           padding:15px;
           margin: 5px 0 22px 0;
           display: inline-block;
           background: whitesmoke;
           border: none;
           outline:none;
           
           border-radius: 15px;

         }
         input[type=text]:focus,input[type=password]:focus
       {
           background-color: #ddd;
           outline:none;
       }
       input[type=button], input[type=submit]{
        background-color:whitesmoke;
           color: black;
           padding: 16px 20px;
           margin: 8px;
           cursor: pointer;
           text-align: center;
           width: 40%;
           opacity: 0.7;
           border-radius: 15px;
           cursor: pointer;
           font-weight: bolder;
           font-size: medium;
           font-family: Georgia, 'Times New Roman', Times, serif;
           
       }
       button:hover{
           opacity: 2;
       }
       .imgholder{
           text-align: center;
           margin: 24px 0 12px 0;
           position: relative;
       }
       img.avatar{
           border-radius: 40%;
           width: 30%;
       }
     </style>
    </head>
    <body>
          <div class="backgimg"></div>
        <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        %>
        
        <h2>Hello World!</h2>
        <br/>
        
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
         
         <br/>
         <html:form action="DoLogout">
            <html:submit value="Log Out"/> 
         
        </html:form>
       
        <br/>
        <a href="GenerateNotice.jsp"><input type="button" value="Generate Notice"></a>
        <br/>
        <a href="AddUsers.jsp"><input type="button" value="Add Users"></a>
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
          request.setAttribute("Notices", null);
          }

        
        }catch(Exception e)
        {
        System.out.println(e);
        }
        
        
        
        %>
    </body>
</html>
