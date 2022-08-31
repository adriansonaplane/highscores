package dev.ledesma.sanitizer;

import dev.ledesma.entities.Account;

public interface AccountSanitizer {

    Account sanitize(Account account);

}
