package com.pet.controller;

import com.pet.bean.Account;
import com.pet.dao.AccountMapper;
import com.pet.service.AccountService;
import com.pet.service.ContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by xinzhendi-031 on 2017/8/21.
 * 用户相关操作
 */
@Controller
@RequestMapping("contacts")
public class ContactsController extends AbsController {
    private static final Logger log = LoggerFactory.getLogger(ContactsController.class);

    @Autowired
    private ContactsService contactsService;
    @Autowired
    private AccountService accountService;

    /**
     * 不包含自己
     * */
    @GetMapping("select")
    @ResponseBody
    public Object getMyContacts(@RequestParam Map param) {
        try {
            List<Account> contacts = contactsService.getMyContacts(param);
            return ajax(contacts);
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ajax(e);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ajax(e);
        }
    }
}
