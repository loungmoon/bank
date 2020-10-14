package com.innoveller.bank_app;
import com.innoveller.bank_app.models.BankAccount;
import com.innoveller.bank_app.models.BankServiceDB;
import com.innoveller.bank_app.models.Transaction;

import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BankServiceDB bank = new BankServiceDB();
        //BankAccount dawMyaAye = bank.createAccount("Daw Mya Aye","DEPOSIT",200000);
        //BankAccount uTunAung = bank.createAccount("U Tun Aung","DEPOSIT",100000);

        BankAccount dawMyaAye = bank.findAccount(1L);
        BankAccount uTunAung = bank.findAccount(2L);

        bank.deposit(dawMyaAye, 10000);
        bank.deposit(uTunAung, 20000);

        bank.withdraw(dawMyaAye, 10000);

        bank.transfer(dawMyaAye, uTunAung, 20000);

        List<Transaction> transactions = bank.getAccountTransactionList(dawMyaAye);
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getTransactionType() + " Amount " + transaction.getAmount() + " At Date" + transaction.getTransactionDate());


//            Calendar calendar = Calendar.getInstance();
//            calendar.set(Calendar.YEAR, 2020);
//            calendar.set(Calendar.MONTH, 9);
//            calendar.set(Calendar.DATE, 14);
//
//            bank.reportForOneDay(calendar.getTime());

            Calendar from_date_cal = Calendar.getInstance();
            from_date_cal.set(Calendar.YEAR, 2020);
            from_date_cal.set(Calendar.MONTH, 9);
            from_date_cal.set(Calendar.DATE, 1);

            Calendar to_date_cal = Calendar.getInstance();
            to_date_cal.set(Calendar.YEAR, 2020);
            to_date_cal.set(Calendar.MONTH, 9);
            to_date_cal.set(Calendar.DATE, 14);

            bank.reportOfDateRange(from_date_cal.getTime(),to_date_cal.getTime());

        }
    }
}