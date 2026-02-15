package com.georgiiHadzhiev.component;

import com.georgiiHadzhiev.entity.AppUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {


    public UserDetails fromAppUser(AppUser user){

        if(user == null) return null;

       return User.builder()
                .password(user.getPassword())
                .username(user.getUsername())
                .roles(user.getRole())
                .build();
    }
}
