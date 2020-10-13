package com.innoveller.hibernatedemo.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BankServiceDB implements BankService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    EntityManager em = emf.createEntityManager();

    public void saveTransaction(double amount, String transactionType, BankAccount bank) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionDate(transaction.getTransactionDate());
        transaction.setTransactionType(transactionType);
        transaction.setBankAccountId(bank);
        em.persist(transaction);
    }


    public BankAccount findAccount(Long id) {
        return null;
    }

    public BankAccount createAccount(String accountHolder, String accountType, double balance) {
        em.getTransaction().begin();
        int accountNo = (int) (Math.random() * 100000000);
        BankAccount bank = new BankAccount();

        bank.setAccountNo(accountNo);
        bank.setAccountHolder(accountHolder);
        bank.setAccountType(accountType);
        bank.setOpendate(bank.getOpendate());
        em.persist(bank);

        saveTransaction(balance,bank.getAccountType(),bank);
        em.getTransaction().commit();
//        em.close();
        return  bank;
    }

    public void deposit(BankAccount bank, double amount) {
        saveTransaction(amount,"Deposit",bank);
    }

    public void withdraw(BankAccount account, double amount) {

    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {

    }
}
