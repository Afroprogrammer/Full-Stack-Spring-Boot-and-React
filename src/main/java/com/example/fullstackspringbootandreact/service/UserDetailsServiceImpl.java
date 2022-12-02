package com.example.fullstackspringbootandreact.service;

import com.example.fullstackspringbootandreact.domain.CustomUserDetailsImpl;
import com.example.fullstackspringbootandreact.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not Found"));
        return new CustomUserDetailsImpl(user);
    }
}
