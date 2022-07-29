package com.saha.bankapi.request;

import com.saha.bankapi.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DoTransferRequest {
    private String sourceAccount;
    private String destinationAccount;
    private double Amount;
}
