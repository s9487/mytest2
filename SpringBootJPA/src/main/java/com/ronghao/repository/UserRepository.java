package com.ronghao.repository;

import com.ronghao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {
   @Query("from User where username=?")
    User findByname(String username);
}
