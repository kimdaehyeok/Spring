package com.spring.chapter2.bankapp.controller;

import com.spring.chapter2.bankapp.domain.FixedDepositDetails;
import com.spring.chapter2.bankapp.service.FixedDepositService;

public interface FixedDepositController
{
    public FixedDepositService getFixedDepositService();
    
    public boolean submit();

    public FixedDepositDetails get();
}
