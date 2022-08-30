package dev.ledesma.repos;

import dev.ledesma.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

    List<Account> getAccountsByInitials(String initials);
}
