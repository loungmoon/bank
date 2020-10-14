package com.innoveller.hibernatedemo;
import com.innoveller.hibernatedemo.models.BankAccount;
import com.innoveller.hibernatedemo.models.BankServiceDB;
import com.innoveller.hibernatedemo.models.Transaction;

import java.util.Date;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        BankServiceDB bank = new BankServiceDB();

       // BankAccount bankAccount = bank.findAccount(34L);
//        List<Transaction> transactions = bank.getAccountTransactionList(bankAccount);
//        for (Transaction transaction : transactions) {
//            System.out.println(transaction.getTransactionType() + " Amount " + transaction.getAmount() + " At Date" + transaction.getTransactionDate());

            // BankAccount bankAccount=bank.findAccount(34L);
             bank.reportForOneDay(new Date(2020,10,13));
            //bank.deposit(bankAccount,20000);
            //bank.withdraw(bankAccount,130000);
            // BankAccount bankAccount1 = bank.findAccount(31L);
            // bank.transfer(bankAccount,bankAccount1,10);

            //System.out.println(bankAccount.getAccountType());
            // BankAccount account=bank.createAccount("Nang Khan Aye","DEPOSIT",200000);

            // bank.deposit(bankAccount,100);
            // em.getTransaction().commit();
       // }
    }
}