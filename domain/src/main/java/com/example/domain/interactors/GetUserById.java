package com.example.domain.interactors;

import com.example.domain.models.UserModel;
import com.example.domain.models.UserModelMapper;
import com.example.domain.repos.UserRepo;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetUserById implements GetUserByIdUseCase {

    private UserRepo userRepo;

    @Inject
    public GetUserById(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Single<UserModel> execute(int id){
        return userRepo.getUser(id)
                .map(UserModelMapper::userToModel);
    }
}
