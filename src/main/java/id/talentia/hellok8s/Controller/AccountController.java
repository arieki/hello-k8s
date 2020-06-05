package id.talentia.hellok8s.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import id.talentia.hellok8s.model.Account;
import id.talentia.hellok8s.services.AccountService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/allAccount")
    public ResponseEntity<List<Account>> getListAccount() {
        log.info("AccountController.getListAccount");
        return new ResponseEntity<List<Account>>(accountService.getAllAccount(), HttpStatus.OK);
    }

}