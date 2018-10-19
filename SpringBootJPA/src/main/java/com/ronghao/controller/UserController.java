package com.ronghao.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronghao.domain.User;
import com.ronghao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
   //
    private User user;

    @GetMapping(value = "/demo01")
    public List<User> findAll(){
       return   userRepository.findAll();
    }

    @GetMapping(value = "/redis")
    public User findById(@RequestParam  String username) throws Exception {
     //先判断redis中是否有这人
        String s1 = redisTemplate.boundValueOps(username).get();
        //没有从mysql 中查,在存入redis
        if (s1==null){

            User user = userRepository.findByname(username);
            //转换成Fsjon
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(user);
            //存入redis
            redisTemplate.boundValueOps(username).set(s);

            System.out.println(" 从mysql中查到的数据为"+s);
            return user;
        }else {//有从redis中查

            String s = redisTemplate.boundValueOps(username).get();
            //将json 装换成对象
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.convertValue(s, User.class);
            System.out.println("从redis中查到的数据为"+s);
            return user;

        }



    }


}
