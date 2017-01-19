package com.cuking.Dao;

import com.cuking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by cuking on 2017/1/5.
 */
public interface UserDao extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    @Query("from User u where u.username=:username")
    User findUser(@Param("username") String username);

}
