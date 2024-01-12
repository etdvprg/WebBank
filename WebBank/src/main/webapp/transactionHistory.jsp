<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Transaction"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.Account"%>

<%
    Account account = (Account) session.getAttribute("account");
    List<Transaction> transactions = (List<Transaction>) session.getAttribute("transactions");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction History</title>
    </head>
    <body>
        <h1>Transaction History</h1>
        <% if (transactions != null && !transactions.isEmpty()) { %>
        <table border="1">
            <tr>
                <td>Transaction ID</td>
                <td>Amount</td>
                <td>Date</td>
                <td>Type</td>
            </tr>
            <% for (Transaction t : transactions) {%>
            <tr>
                <td><%= t.getTransactionId()%></td>
                <td><%= t.getAmount()%></td>
                <td><%= t.getDate()%></td>
                <td>
                    <% if (t.getSenderId() == account.getId()) { %>
                    Sender
                    <% } else { %>
                    Receiver
                    <% } %>
                </td>
            </tr>
            <% } %>
        </table>
        <% } else { %>
        <p>No transaction history found.</p>
        <% }%>
        <form action="/WebBank/AccountRetrievalServlet" method="GET">
            <input type="submit" value="Return">
        </form>
    </body>
</html>

