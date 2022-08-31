package dev.ledesma.sanitizer;

import dev.ledesma.entities.Account;

public class AccountSanitizerImpl implements AccountSanitizer {
    @Override
    public Account sanitize(Account account) {

        Account sanitizedAccount = account;

        sanitizedAccount.setInitials(sanitizedAccount.getInitials().toUpperCase());

        if(sanitizedAccount.getInitials().length() > 3){
            sanitizedAccount.setInitials(sanitizedAccount.getInitials().substring(0,3));
        }

        return sanitizedAccount;
    }
}
