package com.ronghao.test;

import com.ronghao.domain.User;
import com.ronghao.repository.UserRepository;
import com.ronghao.springBootdemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = springBootdemo.class)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll(){
        List<User> all = userRepository.findAll();
        System.out.println(all);
    }

}
