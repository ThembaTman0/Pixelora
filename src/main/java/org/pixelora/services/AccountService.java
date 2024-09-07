package org.pixelora.services;

import org.pixelora.model.Account;
import org.pixelora.repositories.AccountRepository;
import org.pixelora.util.constants.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    @Autowired // Automatically injects the AccountRepository bean into this field
    private AccountRepository accoutRepository;

    @Autowired // Automatically injects the AccountRepository bean into this field
    private PasswordEncoder passwordEncoder;

    public Account save(Account account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(Roles.USER.getRole());
        return accoutRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accoutRepository.findOneByEmailIgnoreCase(email);
        if(!optionalAccount.isPresent()){
            throw  new UsernameNotFoundException("Account not found");
        }
        Account account = optionalAccount.get();

        List<GrantedAuthority> grantedAuthority = new ArrayList<>();
        grantedAuthority.add(new SimpleGrantedAuthority(account.getRole()));

        // Return a User object containing the account's email, password, and authorities
        // The User class implements UserDetails, which is required by Spring Security
        return new User(account.getEmail(),account.getPassword(),grantedAuthority);
    }
}
