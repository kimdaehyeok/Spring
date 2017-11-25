package com.spring.chapter2.bankapp.service;

import com.spring.chapter2.bankapp.dao.FixedDepositDao;
import com.spring.chapter2.bankapp.domain.FixedDepositDetails;

public interface FixedDepositService
{
    public FixedDepositDao getFixedDepositDao();

    public FixedDepositDetails getFixedDepositDetails(long id);

    public boolean createFixedDeposit(FixedDepositDetails fdd);
}
