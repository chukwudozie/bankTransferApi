package com.saha.bankapi.controller;

import com.saha.bankapi.request.DoTransferRequest;
import com.saha.bankapi.response.ApiResponse;
import com.saha.bankapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/doTransfer")
    public ResponseEntity<ApiResponse> doTransfer(@RequestBody DoTransferRequest request){
//f
//        transactionService.calculateDiscount();
        return null;

    }


}
