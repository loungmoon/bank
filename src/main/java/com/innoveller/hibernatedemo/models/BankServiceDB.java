package com.innoveller.hibernatedemo.models;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
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
        List<Transaction> transactionList = new ArrayList<Transaction>();
        double totalAmount = 0.0;
        try {
            transactionList.add(em.find(Transaction.class, bank_account_id));
        }catch (Exception ex){
            System.out.println("Error");
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
//        em.close();
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
            }
        }catch (Exception ex){
            System.out.println("error");
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
        } catch (Exception e) {
            System.out.println("Cannot Transfer");
        }em.getTransaction().commit();

    }

}
