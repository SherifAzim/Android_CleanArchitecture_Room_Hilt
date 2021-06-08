package com.example.domain.repos;

import android.content.Context;

import com.example.data.UserDatabase;
import com.example.data.tables.User;
import com.example.domain.models.UserModel;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;
import io.reactivex.Single;

public class UserRepo {


    public  UserDatabase database;
    private Context context;

    public UserRepo(Context context) {
        this.database = UserDatabase.getInstance(context);
    }

    @Inject
    public UserRepo(UserDatabase database, @ApplicationContext Context context) {
        this.database = database;
        this.context = context;
    }

    public Single<User> getUser(int id){
        return database.userDAO().getUser(id);
    }

    public Single<Long> insertUser(User user){
        return database.userDAO().insert(user);
    }
}
