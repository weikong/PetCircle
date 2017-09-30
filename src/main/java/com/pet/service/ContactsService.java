package com.pet.service;

import com.pet.bean.Account;
import com.pet.dao.AccountMapper;
import com.pet.dao.ContactsMapper;
import com.pet.dao.CustAccountMapper;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by xinzhendi-031 on 2017/8/21.
 */

@Service
@Transactional
public class ContactsService {
    private static final Logger log = LoggerFactory.getLogger(ContactsService.class);
    @Autowired
    private ContactsMapper contactsMapper;
    @Autowired
    private CustAccountMapper custAccountMapper;

    public List<Account> getMyContacts(Map param) {
        int id = MapUtils.getInteger(param, "id", -1);
        List<Account> list = custAccountMapper.selectMyContacts(id);
        return list;
    }
}
