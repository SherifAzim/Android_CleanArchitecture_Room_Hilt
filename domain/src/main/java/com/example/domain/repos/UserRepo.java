package com.example.domain.repos;

import android.content.Context;

import com.example.data.UserDatabase;
import com.example.data.tables.User;
import com.example.domain.UserModel;

import javax.inject.Inject;

import io.reactivex.Single;

public class UserRepo {


    public  UserDatabase database;

    public UserRepo(Context context) {
        this.database = UserDatabase.getInstance(context);
    }

    @Inject
    public UserRepo(UserDatabase database) {
        this.database = database;
    }

    public Single<User> getUser(int id){
        return database.userDAO().getUser(id);
    }

    public Single<Long> insertUser(UserModel user){
        return database.userDAO().insert(new User(user.getName(),user.getAge()));
    }
}
