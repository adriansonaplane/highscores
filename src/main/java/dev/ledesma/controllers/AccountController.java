package dev.ledesma.controllers;

import dev.ledesma.entities.Account;
import dev.ledesma.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/accounts")
    @ResponseBody
    public ResponseEntity<Account> createAccount(@RequestBody Account account){

        Account savedAccount = this.accountService.registerAccount(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);

    }

    @PutMapping("/accounts/{id}")
    @ResponseBody
    public ResponseEntity<Account> updateAccount(@PathVariable String id, @RequestBody Account account){

        int accountId = Integer.parseInt(id);
        Account updatedAccount = this.accountService.updateAccount(accountId, account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.CREATED);
    }

    @GetMapping("/accounts")
    @ResponseBody
    public List<Account> allAccounts(@RequestParam(required = false) String initials){

        if(initials == null){ return accountService.getAllAccounts();}
        else { return accountService.getAccountsByInitials(initials); }
    }

    @GetMapping("/accounts/{id}")
    @ResponseBody
    public Account getAccountById(@PathVariable String id){

        int accountId = Integer.parseInt(id);
        return accountService.getAccountById(accountId);

    }

    @DeleteMapping("/accounts/{id}")
    @ResponseBody
    public Account deleteAccountById(@PathVariable String id){

        int accountId = Integer.parseInt(id);
        return accountService.deleteAccount(accountId);

    }

}
