package org.example.exercice_dao.model;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private int id;
    private Account account;
    private double amount;
    private String status;

    private static final List<String> statusList = getStatusList();

    private static List<String> getStatusList() {
        statusList.add("DEPOSIT");
        statusList.add("WITHDRAWAL");
        statusList.add("TRANSFER");
        return statusList;
    }

    public Transaction(int id, Account account, double amount, String status) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.status = "TRANSFER";
        for (String statusInList : statusList){
            if(statusInList.equalsIgnoreCase(status)) this.status = statusInList;
        }
    }

    public Transaction(Account account, double amount, String status) {
        this.id = id;
        this.account = account;
        this.amount = amount;
        this.status = "TRANSFER";
        for (String statusInList : statusList){
            if(statusInList.equalsIgnoreCase(status)) this.status = statusInList;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", account=" + account +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
