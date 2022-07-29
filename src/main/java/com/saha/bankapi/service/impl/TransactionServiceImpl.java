package com.saha.bankapi.service.impl;

import com.saha.bankapi.model.Customer;
import com.saha.bankapi.model.ENUM.CustomerType;
import com.saha.bankapi.model.Transaction;
import com.saha.bankapi.repository.CustomerRepository;
import com.saha.bankapi.repository.TransactionRepository;
import com.saha.bankapi.service.TransactionService;

import java.time.LocalDate;


public class TransactionServiceImpl implements TransactionService {

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void calculateDiscount(Transaction transaction) {

        if(transactionRepository.findById(transaction.getId()).isPresent()) {
            if (transaction.getSender().getCustomerType().equals(CustomerType.BUSINESS_USER)
                    && transaction.getTransactionAmount() > 150000 && numberOfTransactionsInLastThreeMonths(transaction) >= 3) {
                double deduction = 0.27 * transaction.getTransactionCharge();
                transaction.setTransactionCharge(transaction.getTransactionCharge() - deduction);
            }

            if (transaction.getSender().getCustomerType().equals(CustomerType.RETAIL_USER)
                    && transaction.getTransactionAmount() > 50000 && numberOfTransactionsInLastThreeMonths(transaction) > 3) {
                double deduction = 0.18 * transaction.getTransactionCharge();
                transaction.setTransactionCharge(transaction.getTransactionCharge() - deduction);
            }
        }
//        else {
//
//        }


    }

    private  int numberOfTransactionsInLastThreeMonths(Transaction transaction){
        LocalDate currentTimeOfTransaction = transaction.getTimeOfTransaction();
        LocalDate lastThreeMonths = currentTimeOfTransaction.minusMonths(3);
        return  transactionRepository.findTransactionsBySenderAndTimeOfTransactionBetween
                (transaction.getSender(),lastThreeMonths,currentTimeOfTransaction).size();
    }
}
