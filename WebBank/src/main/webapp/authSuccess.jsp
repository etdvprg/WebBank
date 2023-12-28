<%-- 
    Document   : authSuccess
    Created on : Dec 28, 2023, 3:27:07 PM
    Author     : EnceT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Authentication Successful!</h1>
        <p> You may now view your bank details </p>
        
        <form action="/WebBank/AccountRetrievalServlet" method="GET">
            <input type="submit" value="View Account Details">
        </form>
        
    </body>
</html>

