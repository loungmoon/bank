package com.innoveller.hibernatedemo.models;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public double calculatedTotalBalance(Long bank_account_id) {
        List<Transaction> transactionList = new ArrayList<>();
        double totalAmount = 0.0;
        try {
            Query query =em.createQuery("FROM Transaction  WHERE bankAccount.id = ?1");
            query.setParameter(1,bank_account_id);
            transactionList  =  query.getResultList();
        }catch (Exception ex){
            System.out.println("Exception Error !!");
        }
            for (Transaction transaction : transactionList) {
                if (transaction.getTransactionType().equals("DEPOSIT")) {
                    totalAmount += transaction.getAmount();
                } else if (transaction.getTransactionType().equals("WITHDRAW")) {
                    totalAmount -= transaction.getAmount();
                } else {
                    totalAmount -= transaction.getAmount();
                }
            }
        return totalAmount;
    }

    public BankAccount findAccount(Long id) {
        double total = calculatedTotalBalance(id);
        System.out.println(total);
        return em.getReference(BankAccount.class, id);
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
        return  bank;
    }

    public void deposit(BankAccount bank, double amount) {
        em.getTransaction().begin();
        saveTransaction(amount,"DEPOSIT",bank);
        em.getTransaction().commit();
    }

    public void withdraw(BankAccount account, double amount) {
        em.getTransaction().begin();
        try {
            double totalBalance = calculatedTotalBalance(account.getId());
            if (totalBalance > amount) {
                saveTransaction(amount, "WITHDRAW", account);
            }else{
                System.out.println("Cannot Withdraw !! You balance have "+totalBalance);
            }
        }catch (Exception ex){
            System.out.println("Exception Error !!");
        }
        em.getTransaction().commit();
        }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
        em.getTransaction().begin();
        try {
            double totalAmount = calculatedTotalBalance(fromAccount.getId());
            if (totalAmount > amount) {
                saveTransaction(amount, "TRANSFER", fromAccount);
                saveTransaction(amount, "DEPOSIT", toAccount);
            }
            else {
                System.out.println("Cannot Transfer !! You balance have "+totalAmount);
            }
        } catch (Exception e) {
            System.out.println("Exception Error !!");
        }em.getTransaction().commit();
    }

    public List<Transaction> getAccountTransactionList(BankAccount account) {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            Query query =em.createQuery("FROM Transaction  WHERE bankAccount.id = ?1");
            query.setParameter(1,account.getId());
            transactionList  =  query.getResultList();
        }  catch (Exception e) {
                System.out.println("Exception Error !!");
        }
        return transactionList;
    }

    public void reportOfDateRange(Date from_date, Date to_date) {
        List<Transaction> transactionList = new ArrayList<>();
        try {
            Query query =em.createQuery("from Transaction where transactionDate BETWEEN :fromdate and :todate");
            query.setParameter("fromdate", from_date);
            query.setParameter("todate", to_date);
            transactionList = query.getResultList();

        } catch (Exception ex) {
                System.out.println("Exception Error !!");
            }
        for(Transaction transaction:transactionList){
            System.out.println("Transaction Type :"+transaction.getTransactionType() + " Amount : " + transaction.getAmount()+" Bank_Account_ID: "+transaction.getBankAccount());
        }
    }

    public void reportForOneDay(LocalDate date) {
        em.getTransaction().begin();
        List<Transaction> transactionList = new ArrayList<>();
        try {
            Query query = em.createQuery("from Transaction where transactionDate= ?1");
            query.setParameter(1,date);
            transactionList = query.getResultList();
        } catch (Exception ex) {
                System.out.println("Exception Error !!");
        }
        for(Transaction transaction:transactionList){
            System.out.println("Transaction Type :"+transaction.getTransactionType() + " Amount : " + transaction.getAmount()+" Bank_Account_ID: "+transaction.getBankAccount());
        }
        em.getTransaction().commit();
    }
}
