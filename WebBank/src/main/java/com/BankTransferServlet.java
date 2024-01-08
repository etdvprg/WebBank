package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BankTransferServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int recipientId = Integer.parseInt(request.getParameter("recipientID"));
        double remitAmount  = Double.parseDouble(request.getParameter("amount"));
        
        HttpSession session = request.getSession();
        Account currentAccount = (Account) session.getAttribute("account");
        
        if (currentAccount == null || currentAccount.getBalance() < remitAmount) {
            response.sendRedirect("/WebBank/errorLowAmt.jsp");
        }
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_bank?useSSL=false", "root", "root");

            String transactionID = UUID.randomUUID().toString();
            
            String sqlTransact = "INSERT INTO transactions (id, sender_id, receiver_id, amount, date) VALUES (?, ?, ?, ?, CURDATE())";
            PreparedStatement stmtTransact = conn.prepareStatement(sqlTransact, Statement.RETURN_GENERATED_KEYS);
            stmtTransact.setString(1, transactionID);
            stmtTransact.setInt(2, currentAccount.getId());
            stmtTransact.setInt(3, recipientId);
            stmtTransact.setDouble(4, remitAmount);
            stmtTransact.executeUpdate();
            
            
            
            String sqlUpdateCurrentAccount = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            PreparedStatement stmtUpdateCurrentAccount = conn.prepareStatement(sqlUpdateCurrentAccount);
            stmtUpdateCurrentAccount.setDouble(1, remitAmount);
            stmtUpdateCurrentAccount.setInt(2, currentAccount.getId());
            stmtUpdateCurrentAccount.executeUpdate();

            TransactionData td = new TransactionData(conn);
            Transaction trans = td.getTransactionInfo(transactionID);
            session.setAttribute("transaction", trans);
            
            response.sendRedirect("/WebBank/xferSuccess.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
          throw new ServletException(ex);
      }
        
        
    }


}
