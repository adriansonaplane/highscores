package dev.ledesma.validator;

import dev.ledesma.entities.Account;

public class AccountValidatorImpl implements AccountValidator {
    @Override
    public Boolean validate(Account account) {
        Account validatedAccount = account;
        if(validatedAccount.getPoints() < 0 ){ return false; }else { return true; }

    }
}
