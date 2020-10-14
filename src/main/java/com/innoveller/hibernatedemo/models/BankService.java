package com.innoveller.hibernatedemo.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BankService {

    BankAccount findAccount(Long id);
    BankAccount createAccount(String accountHolder, String accountType,double balance);
    void deposit(BankAccount account,double amount);
    void withdraw(BankAccount account,double amount);
    void transfer(BankAccount fromAccount,BankAccount toAccount,double amount);
    List<Transaction> getAccountTransactionList(BankAccount account);
    //void reportOfDateRange(Date from_date, Date to_date);
    void reportForOneDay(Date date);
}
