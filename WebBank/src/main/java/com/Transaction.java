package com;

import java.sql.*;

public class Transaction {
    private String transactionId;
    private int senderId;
    private int receiverId;
    private double amount;
    private Timestamp tmp;
    
    public Transaction(String transactionId, int senderId, int receiverId, double amount, Timestamp tmp) {
        this.transactionId = transactionId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.tmp = tmp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getDate() {
        return tmp;
    }
}
