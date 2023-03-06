<%-- 
    Document   : welcome
    Created on : Feb 24, 2023, 9:22:50 AM
    Author     : 0837099
--%>
<link rel="stylesheet" href="Styles/maincss.css" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Here is the information that you entered:</p>


        <label>User First Name:</label>
        <span>${customer.firstName}</span><br>
        <label>Info</label>
        <span>customer ID:</span>
        <span>${customer.customerID}</span><br>
        <span>customer ID:</span>
        <span>${customer.lastName}</span><br>
        <span>customer phone:</span>
        <span>${customer.phoneNum}</span><br>

        <label>You have two options here:</label> <br>
        <form action="DisplayAccountServlet" method="POST">
            <input type="hidden" name="option" value ="accounts"/>
            <input type = "submit" value = "Show accounts"/>
            <br>

        </form>
        <form action="DisplayAccountServlet" method="POST">
            <input type="hidden" name="option" value ="logout"/>
            <input type = "submit" value = "Logout"/>
        </form>








    </body>
</html>
