<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    Generate Notice
    <body style="background-color: white">  
         <%
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        %>
        <h3><bean:message key="welcome.heading"/></h3>
        <html:form action="GenNotice">
            <table cellspacing="7">
                <tr>
                    <td>Notice Subject </td>
                    <td>
                        <html:textarea property="noticesubject"/>
                    </td>
                </tr>
                <tr>
                    <td>Write Notice in following box: </td>
                    <td>
                        <html:textarea property="noticetext"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <html:submit value="Generate"/>                             
                    </td>                   
                </tr>
            </table>
        </html:form>
        <br/>
        <br/>
        
    <%
      try{
                    HttpSession hs=request.getSession(true);
                    
                    if((hs.getAttribute("generate_notice_status"))!=null){
                    if(hs.getAttribute("generate_notice_status").equals("1"))
                    {
                        %><p>Notice Generated Successfully</p>
                     <%}
                       
                    
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
    
</html:html>
