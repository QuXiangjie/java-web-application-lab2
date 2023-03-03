<%-- 
    Document   : transactionlist
    Created on : Mar 3, 2023, 3:59:20 PM
    Author     : 0837099
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach var="item" items="${transactions}">
        <tr>
            <td>${item.transactionID}</td>

        </tr>
    </c:forEach>

    <form action="DisplayTransactionServlet" method="post">
        <input type="hidden" name="option" value="backaccount">

        <input type="submit" value="Back">
    </form>
</body>
</html>
