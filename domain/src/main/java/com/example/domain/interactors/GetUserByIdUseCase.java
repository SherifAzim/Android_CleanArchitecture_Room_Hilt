package com.example.domain.interactors;

import com.example.domain.models.UserModel;

import io.reactivex.Single;

public interface GetUserByIdUseCase {

    public Single<UserModel> execute(int id);
}
