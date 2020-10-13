package com.innoveller.hibernatedemo;
import com.innoveller.hibernatedemo.models.BankAccount;
import com.innoveller.hibernatedemo.models.BankServiceDB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();

        BankServiceDB bank = new BankServiceDB();
        BankAccount bankAccount=bank.findAccount(32L);



        //System.out.println(bankAccount.getAccountType());
        //BankAccount account=bank.createAccount("Khan Aye","DEPOSIT",10000);

       // bank.deposit(bankAccount,100);
       // em.getTransaction().commit();
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