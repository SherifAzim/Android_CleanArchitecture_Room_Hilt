package com.example.domain.interactors;

import com.example.domain.models.UserModel;
import com.example.domain.models.UserModelMapper;
import com.example.domain.repos.UserRepo;

import javax.inject.Inject;

import io.reactivex.Single;

public class InsertUser  implements InsertUserUseCase{

    private final UserRepo userRepo;

    @Inject
    public InsertUser(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Single<Long> execute(UserModel userModel) {
        return userRepo.insertUser(UserModelMapper.ModelToUser(userModel));
    }
}
