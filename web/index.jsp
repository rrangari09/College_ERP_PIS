<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
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
        input[type=submit]{
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
           <br/>
           
         <div class="holder">
        
        <html:form action="Login">
             <div class="imgholder">
                 <h2>College ERP</h2>
             <img src="login.png"/ class="avatar"></div>
            <table cellspacing="7">
                <tr>
                    <td <label>Email ID</label></br></td>
                    <td>
                        <html:text property="emailid"/>
                    </td>
                </tr>
                <tr>
                    <td> <label>Password</label> </td>
                    <td>
                        <html:text property="password"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                         <html:submit value="Submit"/>                             
                    </td>                   
                </tr>
            </table>
        </html:form>
         </div>    
    </body>
</html:html>
