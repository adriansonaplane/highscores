package dev.ledesma.services;

import dev.ledesma.entities.Account;
import dev.ledesma.exceptions.AccountNotFoundException;
import dev.ledesma.exceptions.PointsAreNegativeException;
import dev.ledesma.repos.AccountRepo;
import dev.ledesma.sanitizer.AccountSanitizer;
import dev.ledesma.utils.SortByScore;
import dev.ledesma.validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;
    AccountSanitizer accountSanitizer;

    AccountValidator accountValidator;

    @Override
    public Account registerAccount(Account account) {

        Account tempAccount = account;

        tempAccount.setInitials(tempAccount.getInitials().toUpperCase());

        if(tempAccount.getInitials().length() > 3){
            tempAccount.setInitials(tempAccount.getInitials().substring(0, 3));
        }

        if(tempAccount.getPoints() < 0 ){ throw new PointsAreNegativeException(); }

        Account savedAccount = this.accountRepo.save(tempAccount);
        return savedAccount;
    }

    @Override
    public Account getAccountById(int id) {

        Optional<Account> possibleAccount = this.accountRepo.findById(id);

        if (possibleAccount.isPresent()) { return possibleAccount.get(); }
        else { throw new AccountNotFoundException(); }

    }

    @Override
    public List<Account> getAllAccounts() {

        List<Account> accounts = this.accountRepo.findAll();
        Collections.sort(accounts, new SortByScore());
        return accounts;

    }

    @Override
    public List<Account> getAccountsByInitials(String initials) {

        return this.accountRepo.getAccountsByInitials(initials.toUpperCase());
    }

    @Override
    public List<Account> findByOrderByPointsDesc() {

        List<Account> accounts = this.accountRepo.findByOrderByPointsDesc();
        return accounts;
    }

    @Override
    public Account deleteAccount(int id) {

        Optional<Account> possibleAccount = this.accountRepo.findById(id);

        if (possibleAccount.isPresent()) {

            Account deletedAccount = possibleAccount.get();
            this.accountRepo.delete(deletedAccount);
            return deletedAccount;

        } else { throw new RuntimeException(); }

    }

    @Override
    public Account updateAccount(int id, Account account) {

        Optional <Account> possibleAccount = this.accountRepo.findById(id);

        if(possibleAccount.isPresent()){

            Account tempAccount = possibleAccount.get();

            tempAccount.setInitials(account.getInitials().toUpperCase());

            if (account.getPoints() < 0) { throw new PointsAreNegativeException(); }
            else { tempAccount.setPoints(account.getPoints()); }

            return this.accountRepo.save(tempAccount);

        }else{
            throw new RuntimeException();
        }

    }
}
