package com.georgiiHadzhiev.service;

import com.georgiiHadzhiev.component.UserDetailsMapper;
import com.georgiiHadzhiev.entity.AppUser;
import com.georgiiHadzhiev.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailService implements UserDetailsService {

    private final AppUserRepository userRepository;
    private final UserDetailsMapper mapper;

    public AppUserDetailService(AppUserRepository userRepository, UserDetailsMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> user = userRepository.findByUsername(username);
        if(user.isEmpty()) throw new UsernameNotFoundException("User " + username + " not found!");

        return mapper.fromAppUser(user.get());

    }
}
