package com.spring.chapter2.bankapp.dao;

import com.spring.chapter2.bankapp.domain.FixedDepositDetails;

public interface FixedDepositDao
{
    public FixedDepositDetails getFixedDepositDetails(long id);

    boolean createFixedDeposit(FixedDepositDetails fdd);
}
