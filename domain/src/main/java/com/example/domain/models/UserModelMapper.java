package com.example.domain.models;

import com.example.data.tables.User;

public class UserModelMapper {

    public static UserModel userToModel(User user){

        return new UserModel(user.getName(), user.getAge());
    }

    public static User ModelToUser(UserModel model){

        return new User(model.getName(), model.getAge());
    }
}
