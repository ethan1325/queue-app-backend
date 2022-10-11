package com.ethan.queueapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ethan.queueapp.repository.UserDao;
import com.ethan.queueapp.user.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userRepository;

    public CustomUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User user = userRepository.findByUsername(username);
        // user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user);
        if(user == null){
            throw new UsernameNotFoundException("User not found!");
        }
        // TODO Auto-generated method stub
        return new CustomUserDetails(user);
    }
    
}
