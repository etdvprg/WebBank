package com;

import java.sql.Date;

public class Transaction {
    private String transactionId;
    private int senderId;
    private int receiverId;
    private double amount;
    private Date date;

    public Transaction(String transactionId, int senderId, int receiverId, double amount, Date date) {
        this.transactionId = transactionId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.date = date;
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

    public Date getDate() {
        return date;
    }
}
