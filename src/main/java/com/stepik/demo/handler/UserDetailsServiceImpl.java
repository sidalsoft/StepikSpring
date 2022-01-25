package com.stepik.demo.handler;

import com.stepik.demo.model.User;
import com.stepik.demo.repository.UserRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String login) throws UsernameNotFoundException
    {

        User user = userRepository.findByLogin( login ).orElseThrow( () -> new UsernameNotFoundException( "user not found" ) );

        return new org.springframework.security.core.userdetails.User(

                user.getLogin(),

                user.getPassword(),

                Collections.singletonList( new SimpleGrantedAuthority( "USER")));

    }



}

