package com.innoveller.bank_app.models;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bank_account",schema = "public")
public class BankAccount {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_no")
    private int AccountNo;

    @Column(name = "account_holder")
    private String accountHolder;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "open_date")
    private Date opendate;

    public Long getId() {
        return id;
    }

    public void setAccountNo(int accountNo) {
        AccountNo = accountNo;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getOpendate() {
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        return date;
        }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }
}
