package org.example.demoJPA.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private double balance;
    private String customerName;
    private  String accountNumber;

    public Account(double balance, String customerName, String accountNumber) {
        this.balance = balance;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }
}
