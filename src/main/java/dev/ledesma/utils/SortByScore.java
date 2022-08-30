package dev.ledesma.utils;

import dev.ledesma.entities.Account;

import java.util.Comparator;

public class SortByScore implements Comparator<Account> {

    public int compare(Account a, Account b){
        return b.getPoints() - a.getPoints();
    }
}
