<%-- 
    Document   : Permissions
    Created on : Jan 15, 2021, 8:39:07 PM
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
        <title>Permissions</title>
    </head>
    <body>
        
        <h5> Set Permissions for Generation Of Notices</h5>
        
                <html:form action="AddSub">
                
                    <table cellspacing="15">
                <tr>
                    <td>Admin: </td>
                    <td>
                        <html:text  property="admin" name="adm_permission"/>
                    </td>
                </tr>
                <tr>
                    <td>Faculty: </td>
                    <td>
                        <html:text  property="faculty" name="fac_permission"/>
                    </td>
                </tr>
                
                  <tr>
                    <td>Student :</td>
                    <td>
                        <html:text   property="student" name="std_permission"/>
                    </td>
                </tr>
                    <tr>
                    <td colspan="2">
                        <html:submit value="Set Permission"/>                             
                    </td>                   
                </tr>
                    </table>
            
                </html:form>   
        
    </body>
</html>
