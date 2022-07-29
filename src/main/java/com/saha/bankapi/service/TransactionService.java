package com.saha.bankapi.service;

import com.saha.bankapi.model.Customer;
import com.saha.bankapi.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    void calculateDiscount(Transaction transaction);
}
