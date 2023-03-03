<%-- 
    Document   : accountList
    Created on : Mar 1, 2023, 8:40:35 AM
    Author     : 0837099
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account list</title>
    </head>
    <body>
        <h1>Hello </h1>
    <c:forEach var="item" items="${accounts}">
        
        <tr>
            <td>${item.customerID}</td>
            <!--<td class = "right"></td>-->
        </tr>
    </c:forEach>


</body>
</html>
