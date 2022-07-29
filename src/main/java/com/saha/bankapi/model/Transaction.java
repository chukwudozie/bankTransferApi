package com.saha.bankapi.model;

import com.saha.bankapi.model.ENUM.CustomerType;
import com.saha.bankapi.model.ENUM.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Customer sender;

    @OneToOne
    private Customer receiver;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private double transactionAmount;

//    private Integer count;

    private double transactionCharge = 0.1 * transactionAmount;

    private LocalDate timeOfTransaction = LocalDate.now();

}
