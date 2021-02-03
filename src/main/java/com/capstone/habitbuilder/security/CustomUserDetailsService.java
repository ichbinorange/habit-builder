package com.capstone.habitbuilder.security;

import com.capstone.habitbuilder.enjoyer.Enjoyer;
import com.capstone.habitbuilder.enjoyer.EnjoyerRepository;
import com.capstone.habitbuilder.oauthapi.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    EnjoyerRepository enjoyerRepository;
    @Autowired
    public CustomUserDetailsService(EnjoyerRepository enjoyerRepository) {
        this.enjoyerRepository = enjoyerRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Enjoyer enjoyer = enjoyerRepository.findEnjoyerByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Enjoyer not found with email : " + email)
                );

        return UserPrincipal.create(enjoyer);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Enjoyer enjoyer = enjoyerRepository.findById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("Enjoyer", "id", id)
        );

        return UserPrincipal.create(enjoyer);
    }
}
