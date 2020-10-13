package com.innoveller.hibernatedemo.models;

public interface BankService {

    BankAccount findAccount(Long id);
    BankAccount createAccount(String accountHolder, String accountType,double balance);
    void deposit(BankAccount account,double amount);
    void withdraw(BankAccount account,double amount);
    void transfer(BankAccount fromAccount,BankAccount toAccount,double amount);
//    List<Transaction> getAccountTransactionList(BankAccount account);
//    void reportOfDateRange(LocalDate from_date,LocalDate to_date);
//    void reportForOneDay(LocalDate date);
}
