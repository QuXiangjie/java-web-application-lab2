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
        <h1>${item.customerID}</h1>
        <p>Here are your account</p>

        <table>
            <tr>
                <th>Number</th>
                <th class="right">Name</th>
                <th >balance</th>

                <th >show transaction</th>
            </tr>
            <c:forEach var="item" items="${accounts}">
                <tr>
                    <td>${item.accountNumber}</td>
                    <td >${item.accountName}</td>
                    <td><c:out value="${item.getbalance()}"/></td>
                    <td>
                        <form action="DisplayTransactionServlet" method="post">
                            <input type="hidden" name="option" value="showtranscation">
                            <input type="hidden" name="transactionnumber" value="<c:out value='${item.accountNumber}'/>">
                            <input type="submit" value="Show transcation">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>




    </body>
</html>
