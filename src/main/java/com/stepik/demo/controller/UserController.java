package com.stepik.demo.controller;

import com.stepik.demo.model.User;
import com.stepik.demo.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping( "/users" )
    public User create( @RequestBody User user )
    {
        return userService.create( user );
    }

    @GetMapping( "/users/{login}" )
    public User getUser( @PathVariable( "login" ) String login )
    {
        return userService.findByLogin( login );
    }

}
