package com.example.project.service;

import com.example.project.entity.MyUser;
import com.example.project.service.exceptions.BadDataException;
import com.example.project.service.exceptions.NotFoundException;

public interface MyUserService {
    MyUser createUser(MyUser myUser) throws NotFoundException, BadDataException;
    MyUser getUserById(long userId) throws NotFoundException;
}
