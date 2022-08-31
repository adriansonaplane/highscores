package dev.ledesma.services;

import dev.ledesma.entities.Account;

import java.util.List;

public interface AccountService {

    Account registerAccount(Account account);
    Account getAccountById(int id);
    List<Account> getAllAccounts();
    List<Account> getAccountsByInitials(String initials);
    List<Account> findByOrderByPointsDesc();
    Account deleteAccount(int id);
    Account updateAccount(int id, Account account);

}
