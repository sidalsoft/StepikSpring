package com.stepik.demo.repository;

import com.stepik.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User create( User user );
    User getCurrentUser();
    User findByLogin( String login );

}
