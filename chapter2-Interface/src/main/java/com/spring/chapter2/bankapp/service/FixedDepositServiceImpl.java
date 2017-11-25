package com.spring.chapter2.bankapp.service;

import org.apache.log4j.Logger;

import com.spring.chapter2.bankapp.dao.FixedDepositDao;
import com.spring.chapter2.bankapp.domain.FixedDepositDetails;

public class FixedDepositServiceImpl implements FixedDepositService
{
    private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);
    
    private FixedDepositDao fixedDepositDao;
    
    public FixedDepositServiceImpl()
    {
        logger.info("initializing");
    }
    
    public FixedDepositDao getFixedDepositDao()
    {
        return fixedDepositDao;
    }
    
    public void setFixedDepositDao(FixedDepositDao fixedDepositDao)
    {
        logger.info("Setting fixedDepositDao property");
        this.fixedDepositDao = fixedDepositDao;
    }
    
    public FixedDepositDetails getFixedDepositDetails(long id)
    {
        return fixedDepositDao.getFixedDepositDetails(id);
    }
    
    public boolean createFixedDeposit(FixedDepositDetails fdd)
    {
        return fixedDepositDao.createFixedDeposit(fdd);
    }
    
}
