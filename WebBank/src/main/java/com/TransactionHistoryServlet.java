package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransactionHistoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_bank?useSSL=false", "root", "root");
            String accountId = request.getParameter("accountId");
           
            TransactionData td = new TransactionData(conn);
            
            List<Transaction> transaction = td.getTransactions(Integer.parseInt(accountId));
            
            Collections.sort(transaction, new Comparator<Transaction>() {
                public int compare(Transaction t1, Transaction t2) {
                    return t2.getDate().compareTo(t1.getDate());
                }
            });
            
            session.setAttribute("transactions", transaction);
                       
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
        
        response.sendRedirect("/WebBank/transactionHistory.jsp");
    }
}
