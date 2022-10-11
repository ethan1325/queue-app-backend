package com.ethan.queueapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ethan.queueapp.user.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
