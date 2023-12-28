package com;

public class Account {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String number;
    private String type;
    private double balance;
    
    public Account(int id, String firstName, String middleName, String lastName, String number, String type, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }   
}
