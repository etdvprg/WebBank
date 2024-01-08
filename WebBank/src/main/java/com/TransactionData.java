package com;

import java.sql.*;

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
                Date date = resultSet.getDate("date");

                return new Transaction(transactionId, senderId, receiverId, amount, date);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }  
}
