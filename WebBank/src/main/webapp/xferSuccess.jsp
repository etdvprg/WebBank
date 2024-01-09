<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Transaction"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    Transaction transaction = (Transaction) session.getAttribute("transaction");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Transaction Successful</h1>
        <h1>Transaction Details</h1>
        <% if (transaction != null) {%>
        <p>Transaction ID: <%= transaction.getTransactionId()%></p>
        <p>Sender ID: <%= transaction.getSenderId()%></p>
        <p>Receiver ID: <%= transaction.getReceiverId()%></p>
        <p>Amount: <%= transaction.getAmount()%></p>
        <p>Date: <%= transaction.getDate()%></p>
        <% } else { %>
        <p>No transaction details found.</p>
        <% }%>
        
         <form action="/WebBank/AccountRetrievalServlet" method="GET">
            <input type="submit" value="Return">
        </form>
    </body>
</html>
