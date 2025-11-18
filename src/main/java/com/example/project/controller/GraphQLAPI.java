package com.example.project.controller;

import com.example.project.dto.NewUserInput;
import com.example.project.entity.MyUser;
import com.example.project.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
//@AllArgsConstructor
public class GraphQLAPI {
    private MyUserService myUserService;
    private static final Logger logger = LoggerFactory.getLogger(GraphQLAPI.class);

    public GraphQLAPI(MyUserService myUserService) {
        this.myUserService = myUserService;
    }


    @QueryMapping
    public MyUser getUserById(@Argument Long userId) {
        return myUserService.getUserById(userId);
    }

    @MutationMapping
    public MyUser createUser(@Argument("user") NewUserInput user) {
        logger.info("Input received: {}, {}", user.username(), user.password());
        MyUser myUser = new MyUser();
        myUser.setUsername(user.username());
        myUser.setPassword(user.password());
        return myUserService.createUser(myUser);
    }
}
