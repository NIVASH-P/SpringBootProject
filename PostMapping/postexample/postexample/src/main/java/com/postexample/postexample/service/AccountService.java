package com.postexample.postexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postexample.postexample.Repository.AccountRepo;
import com.postexample.postexample.model.AccountModel;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepo accountRepo;
    public boolean saveData(AccountModel accountModel)
    {
        try{
            accountRepo.save(accountModel);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public List<AccountModel> getData()
    {
        return accountRepo.findAll();
    }

    public AccountModel getDataa(int accNo)
    {
        return accountRepo.findById(accNo).orElse(null);
    }

    public boolean putData(int accNo,AccountModel accountModel)
    {
        try{
            if (getDataa(accNo)!=null) {
                accountRepo.save(accountModel);
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean delmap(int accNo)
    {
        try{
            if(getDataa(accNo) != null)
            {
                accountRepo.deleteById(accNo);
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception exception)
        {
            return false;
        }
    }
    public List<AccountModel> getbyname(String name)
    {
        return accountRepo.getbyName(name);
    }

    public boolean updatebyAccno(int accNo,String name)
    {
        accountRepo.updatebyAccNo(accNo,name);
        return true;
    }
}
