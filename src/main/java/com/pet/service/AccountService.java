package com.pet.service;

import com.pet.bean.Account;
import com.pet.dao.AccountMapper;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by xinzhendi-031 on 2017/8/21.
 */

@Service
@Transactional
public class AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccountById(Map param){
        int id = MapUtils.getInteger(param,"id",-1);
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }
}
