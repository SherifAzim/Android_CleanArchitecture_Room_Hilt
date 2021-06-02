package com.example.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.data.dao.UserDAO;
import com.example.data.tables.User;

@Database(entities = {User.class}, version = 2)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase instance;

    public synchronized static UserDatabase getInstance(Context context) {

        if (instance == null){
            instance = Room.databaseBuilder(context,UserDatabase.class, "user_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
         return instance;
    }

    public abstract UserDAO userDAO();
}
