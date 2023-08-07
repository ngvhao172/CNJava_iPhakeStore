package tdtu.edu.vn.Lab10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tdtu.edu.vn.Lab10.models.Account;
import tdtu.edu.vn.Lab10.repositories.AccountRepository;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public Account getAccount(Account account){
        Optional<Account> foundTK = accountRepository.findById(account.getUsername());
        return foundTK.isPresent() && account.getPassword().equals(foundTK.get().getPassword()) ?
                account : null;
    }
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
