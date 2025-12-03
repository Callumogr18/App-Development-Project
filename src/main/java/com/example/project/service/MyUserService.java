package com.example.project.service;

import com.example.project.entity.MyUser;
import com.example.project.exceptions.BadDataException;

public interface MyUserService {
    MyUser createUser(MyUser myUser) throws NotFoundException, BadDataException;
    MyUser getUserById(long userId) throws NotFoundException;
}
