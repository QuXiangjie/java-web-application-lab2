<%-- 
    Document   : transactionlist
    Created on : Mar 3, 2023, 3:59:20 PM
    Author     : 0837099
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="Styles/maincss.css" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello this is your transaction information:</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>AccountNumber</th>
                <th>Description</th>
                <th>Amount</th>
            </tr>
            <c:forEach var="item" items="${transactions}">
                <tr>
                    <td >${item.transactionID}</td>
                    <td >${item.transactionDate}</td>
                    <td >${item.accountNumber}</td>
                    <td >${item.description}</td>
                    <td >${item.transactionAmount}</td>
                </tr>
            </c:forEach>
        </table>
        <h1>here is the running balances(which also shows in the account choose page):${balance}</h1>


        <form action="DisplayTransactionServlet" method="post">
            <input type="hidden" name="option" value="backaccount">
            <input type="submit" value="Back">
        </form>

    </body>
</html>
