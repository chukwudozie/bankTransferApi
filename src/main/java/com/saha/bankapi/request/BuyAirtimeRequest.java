package com.saha.bankapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuyAirtimeRequest {
    private String sourceAccount;
    private String networkProvider;
    private double amount;
    private String phoneNumber;
}
