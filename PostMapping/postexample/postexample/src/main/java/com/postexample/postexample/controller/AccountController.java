package com.postexample.postexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.postexample.postexample.model.AccountModel;
import com.postexample.postexample.service.AccountService;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;


    @PostMapping("/map")
    public ResponseEntity<AccountModel> requEntity(@RequestBody AccountModel accountModel)
    {
        if (accountService.saveData(accountModel)){
            return new ResponseEntity<>(accountModel,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(accountModel,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List> getEntity()
    {
        List <AccountModel>  list= accountService.getData();
        if (!list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get/{accNo}")
    public ResponseEntity<AccountModel> getEntityy(@PathVariable int accNo)
    {
        AccountModel  list= accountService.getDataa(accNo);
        if (list != null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/put/{accNo}")
    public ResponseEntity<AccountModel> putEntity(@PathVariable int accNo,@RequestBody AccountModel accountModel)
    {
            if(accountService.putData(accNo, accountModel))
            {
                return new ResponseEntity<>(accountModel,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(accountModel,HttpStatus.NOT_FOUND);
            }
    }
    @DeleteMapping("/del/{accNo}")
    public ResponseEntity<AccountModel> delmap(@PathVariable int accNo)
    {
        if(accountService.delmap(accNo))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/gets/{name}")
    public ResponseEntity<List> getEntityy(@PathVariable String name)
    {
        List<AccountModel> list= accountService.getbyname(name);
        if (list != null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("puts/{accNo}/{name}")
    public void getbyName(@PathVariable int accNo,@PathVariable String name)
    {
        accountService.updatebyAccno(accNo,name);
    }
    
}
