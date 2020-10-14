package com.innoveller.hibernatedemo.models;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_date")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column(name = "amount")
    private double amount ;

    @Column(name = "transaction_type")
    private String transactionType;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    public BankAccount bankAccount;

    public Transaction() {
    }

    public Transaction(double amount, String transactionType, BankAccount bankAccount) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.bankAccount = bankAccount;
    }

    public Date getTransactionDate() {
        long millis=System.currentTimeMillis();
        java.sql.Date transactionDate=new java.sql.Date(millis);
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setBankAccountId(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}