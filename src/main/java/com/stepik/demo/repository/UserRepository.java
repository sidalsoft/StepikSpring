package com.stepik.demo.repository;

import com.stepik.demo.model.User;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, Long> {


    @Modifying
    @Query( "SELECT U FROM User U WHERE U.login = :login" )
    Optional<User> findByLogin( @Param( "login" ) String login );

}
