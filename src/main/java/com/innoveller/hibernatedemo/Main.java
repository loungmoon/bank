package com.innoveller.hibernatedemo;
import com.innoveller.hibernatedemo.models.BankAccount;
import com.innoveller.hibernatedemo.models.BankServiceDB;
import com.innoveller.hibernatedemo.models.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        BankServiceDB bank = new BankServiceDB();

        BankAccount account=bank.createAccount("Nang Loung Moon","Withdraw",10000);
        bank.deposit(account,100);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        BankAccount book = new BankAccount();
//
//        book.setAccountNo(1234567);
//        book.setAccountHolder("Daw Moon");
//        book.setAccountType("Deposit");
//        book.setOpendate(book.getOpendate());
//        em.persist(book);
//
//
//        Transaction transaction = new Transaction();
//        transaction.setAmount(1000);
//        transaction.setTransactionDate(transaction.getTransactionDate());
//        transaction.setTransactionType(book.getAccountType());
//        transaction.setBankAccountId(book);
//
//        em.persist(transaction);
//        em.getTransaction().commit();
//        em.close();
    }
}