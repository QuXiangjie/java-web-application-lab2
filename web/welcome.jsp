<%-- 
    Document   : welcome
    Created on : Feb 24, 2023, 9:22:50 AM
    Author     : 0837099
--%>

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
        




    </body>
</html>
