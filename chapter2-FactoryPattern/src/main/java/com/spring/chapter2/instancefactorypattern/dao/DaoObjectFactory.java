package com.spring.chapter2.instancefactorypattern.dao;

public class DaoObjectFactory
{
    public DaoObject getDaoObjectFactory(String selector)
    {
        DaoObject daoObject = null;
        
        if(selector.equalsIgnoreCase("DaoObejctA"))
        {
            daoObject = new DaoObjecA();
        }
        
        if(selector.equalsIgnoreCase("DaoObejctB"))
        {
            daoObject = new DaoObjectB();
        }
        
        return daoObject;
    }
}
