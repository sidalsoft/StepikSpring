package com.stepik.demo.repository;

import com.stepik.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User create( User user )
    {
        user.setPassword( passwordEncoder.encode( user.getPassword() ) );
        return userRepository.save( user );
    }

    @Override
    public User getCurrentUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        return userRepository.findByLogin( principal.getUsername() )
                .orElseThrow( () -> new IllegalArgumentException( "user not found" ) );

    }


    @Override
    public User findByLogin( String login )
    {
        return userRepository.findByLogin( login ).orElse( null );
    }
}
