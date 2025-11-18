package com.example.project.service;

import com.example.project.entity.MyUser;
import com.example.project.repository.MyUserRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@Data
//@AllArgsConstructor
public class MyUserServiceImpl implements MyUserService{
    private MyUserRepo myUserRepo;

    public MyUserServiceImpl(MyUserRepo myUserRepo) {
        this.myUserRepo = myUserRepo;
    }
    @Override
    public MyUser createUser(MyUser myUser) {
        return myUserRepo.save(myUser);
    }

    @Override
    public MyUser getUserById(long userId) {

        return myUserRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }
}
