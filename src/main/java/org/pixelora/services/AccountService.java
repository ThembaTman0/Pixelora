package org.pixelora.services;

import org.pixelora.model.Account;
import org.pixelora.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {
    @Autowired
    private AccountRepository accoutRepository;

    public Account save(Account account){
        return accoutRepository.save(account);
    }
}
