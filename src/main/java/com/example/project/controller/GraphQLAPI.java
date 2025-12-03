package com.example.project.controller;

import com.example.project.dto.NewUserInput;
import com.example.project.entity.MyUser;
import com.example.project.exceptions.NotFoundException;
import com.example.project.service.MyUserService;
import com.example.project.exceptions.BadDataException;
import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
//@AllArgsConstructor
public class GraphQLAPI {
    private MyUserService myUserService;
    private PasswordEncoder passwordEncoder;

    public GraphQLAPI(MyUserService myUserService, PasswordEncoder passwordEncoder) {
        this.myUserService = myUserService;
        this.passwordEncoder = passwordEncoder;
    }


    @QueryMapping
    public MyUser getUserById(@Argument Long userId) throws NotFoundException {
        return myUserService.getUserById(userId);
    }

    @MutationMapping
    public MyUser createUser(@Valid  @Argument("user") NewUserInput user) throws BadDataException, NotFoundException {
        MyUser myUser = new MyUser();
        String encodedPassword = passwordEncoder.encode(user.password());
        myUser.setUsername(user.username());
        myUser.setPassword(encodedPassword);
        myUser.setRole(user.role());
        return myUserService.createUser(myUser);
    }
}
