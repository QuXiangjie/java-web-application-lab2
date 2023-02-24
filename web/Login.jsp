<%-- 
    Document   : Login
    Created on : Feb 15, 2023, 9:23:40 AM
    Author     : 0837099
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="Styles/maincss.css" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="LoginServlet" method="post">
        <input type="hidden" name="option" value="login">  
        
        <label class="pad_top">ID</label>
        <input type="text" name="UserID" required><br>
        
        <label class="pad_top">Password</label>
        <input type="text" name="Password" required><br>
        
        <input type="submit" value="Login in" class="margin_left">
        
    </form>
        
    </body>
</html>
