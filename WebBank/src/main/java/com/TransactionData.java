package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionData {
    private Connection connection;

    public TransactionData(Connection con) {
        this.connection = con;
    }
    
    public Transaction getTransactionInfo(String transactionId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM transactions WHERE ID = ?");
            statement.setString(1, transactionId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int senderId = resultSet.getInt("sender_id");
                int receiverId = resultSet.getInt("receiver_id");
                double amount = resultSet.getDouble("amount");
                Timestamp tmp = resultSet.getTimestamp("date");

                return new Transaction(transactionId, senderId, receiverId, amount, tmp);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public List<Transaction> getTransactions (int accountId) {
        List<Transaction> transactions = new ArrayList<>();
        
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM transactions WHERE sender_id = ? OR receiver_id = ?");
            statement.setInt(1, accountId);
            statement.setInt(2, accountId);

            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String transactionId = resultSet.getString("ID");
                int senderId = resultSet.getInt("sender_id");
                int receiverId = resultSet.getInt("receiver_id");
                double amount = resultSet.getDouble("amount");
                Timestamp tmp = resultSet.getTimestamp("date");

                transactions.add(new Transaction(transactionId, senderId, receiverId, amount, tmp));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
                        
        return transactions;
    }
    
}
