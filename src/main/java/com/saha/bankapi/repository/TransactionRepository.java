package com.saha.bankapi.repository;

import com.saha.bankapi.model.Customer;
import com.saha.bankapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findTransactionsBySenderAndTimeOfTransactionBetween(Customer sender, LocalDate timeOfTransaction, LocalDate timeOfTransaction2);

}
