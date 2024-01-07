<%@page import="com.Account"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    Account account = (Account) session.getAttribute("account");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bank Account Details</h1>
        <% if (account != null) {%>
        <p>Account ID: <%= account.getId()%></p>
        <% if (account.getFirstName() != null) {%>
        <p>First Name: <%= account.getFirstName()%></p>
        <% } %>
        <% if (account.getMiddleName() != null) {%>
        <p>Middle Name: <%= account.getMiddleName()%></p>
        <% } %>
        <% if (account.getLastName() != null) {%>
        <p>Last Name: <%= account.getLastName()%></p>
        <% }%>
        <p>Account Number: <%= account.getNumber()%></p>
        <p>Account Type: <%= account.getType()%></p>
        <p>Balance: <%= account.getBalance()%></p>
        <% } else { %>
        <p>No account details found.</p>
        <% }%>
    </body>
    
    <form action="/WebBank/AuthLogoutServlet" method="GET">
        <input type="submit" value="Logout">
    </form>
    
</html>
