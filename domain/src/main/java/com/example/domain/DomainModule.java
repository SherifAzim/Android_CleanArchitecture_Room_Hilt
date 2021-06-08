package com.example.domain;

import com.example.domain.interactors.GetUserById;
import com.example.domain.interactors.GetUserByIdUseCase;
import com.example.domain.interactors.InsertUser;
import com.example.domain.interactors.InsertUserUseCase;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@InstallIn(ViewModelComponent.class)
@Module
public abstract class DomainModule {


    @Binds
    abstract GetUserByIdUseCase provideGetUserByIdUseCase(GetUserById getUserById);

    @Binds
    abstract InsertUserUseCase provideInsertUserUseCase(InsertUser insertUser);

}
