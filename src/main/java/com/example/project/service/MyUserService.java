package com.example.project.service;

import com.example.project.entity.MyUser;

public interface MyUserService {
    MyUser createUser(MyUser myUser);
    MyUser getUserById(long userId);
}
