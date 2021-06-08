package com.example.domain.interactors;

import com.example.domain.models.UserModel;

import io.reactivex.Single;

public interface InsertUserUseCase {

    public Single<Long> execute(UserModel userModel);
}
