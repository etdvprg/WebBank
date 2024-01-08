<%@page import="com.Account"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    Account account = (Account) session.getAttribute("account");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Money Transfer</title>
    </head>
    <body>
        <form action="/WebBank/BankTransferServlet" method="POST">
            Recipient Account ID: <input type="text" name="recipientID"><br>
            Amount to Tranfer: <input tyipe="number" name="amount"><br>
            <input type="submit" value="Transfer">
        </form>
    </body>
</html>
