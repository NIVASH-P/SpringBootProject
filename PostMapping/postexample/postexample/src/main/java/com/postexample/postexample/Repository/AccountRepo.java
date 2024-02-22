package com.postexample.postexample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.postexample.postexample.model.AccountModel;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRepo extends JpaRepository<AccountModel,Integer>{
    


    @Query("SELECT a FROM AccountModel a where a.name LIKE ?1%")
    public List <AccountModel> getbyName(String name);

    @Query("UPDATE AccountModel a SET a.name = ?2 WHERE a.accNo=?1  ")
    @Modifying
    @Transactional
    public Void updatebyAccNo(int accNo,String newNameString );
}
