package com.application.pinlocation.serviceimplementaion;


import com.application.pinlocation.exception.UserNotFoundException;
import com.application.pinlocation.model.User;
import com.application.pinlocation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        try{
            User user = repository.findByUserName(username);
            return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(), new ArrayList<>());
        }
        catch (Exception exception){
            throw new UserNotFoundException("User not Present with this credentials");
        }
    }
}
