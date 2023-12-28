package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountRetrievalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        
        if (username == null) {
            response.sendRedirect("/WebBank/index.jsp");
        }
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_bank?useSSL=false", "root", "root");
            
            AccountData ad = new AccountData(conn);
            Account act = ad.getAccountInfo(username);
            
            session.setAttribute("account", act);
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }

        response.sendRedirect("/WebBank/bankIdx.jsp");
    }

}
