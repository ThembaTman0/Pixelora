package org.pixelora.services;

import org.pixelora.model.Account;
import org.pixelora.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accoutRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account save(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accoutRepository.save(account);
    }
}
