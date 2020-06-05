package id.talentia.hellok8s.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.talentia.hellok8s.model.Account;
import id.talentia.hellok8s.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccount() {
        log.info("AccountService.getAllAccount");
        List<Account> listAccount = new ArrayList<>();
        accountRepository.findAll().forEach(listAccount::add);
        return listAccount;
    }
}