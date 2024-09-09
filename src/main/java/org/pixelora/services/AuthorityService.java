package org.pixelora.services;

import org.pixelora.model.Authority;
import org.pixelora.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority authority){
        return authorityRepository.save(authority);
    }
}
