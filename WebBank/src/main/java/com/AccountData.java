package com;

import java.sql.*;

public class AccountData {
    private Connection connection;

    public AccountData(Connection con) {
        this.connection = con;
    }

    public Account getAccountInfo(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM accounts WHERE user_id = (SELECT id FROM users WHERE name = ?)");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                String lastName = resultSet.getString("last_name");
                String number = resultSet.getString("number");
                String type = resultSet.getString("type");
                double balance = resultSet.getDouble("balance");

                return new Account(id, firstName, middleName, lastName, number, type, balance);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
