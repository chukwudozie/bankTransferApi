package com.saha.bankapi.model;


import com.saha.bankapi.model.ENUM.CustomerType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String phoneNumber;
    private double accountBalance;
    private String accountNumber;
    private LocalDate dateCreated;

    private CustomerType customerType;

//    @Transient
    private int numberOfTransactions = 0;

    public Customer(String name, String phoneNumber, double accountBalance, CustomerType customerType){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.accountBalance =  accountBalance;
        this.accountNumber = UUID.randomUUID().toString();
        this.dateCreated = LocalDate.now();
        this.customerType = customerType;
    }

    public Customer(String name){
        this.name = name;
        this.accountNumber = UUID.randomUUID().toString();
        this.dateCreated = LocalDate.now();
    }

    public Customer(){
        this.accountNumber = UUID.randomUUID().toString();
        this.dateCreated = LocalDate.now();
    }

}
