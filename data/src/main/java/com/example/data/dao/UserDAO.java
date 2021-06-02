package com.example.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.data.tables.User;

import io.reactivex.Single;

@Dao
public interface UserDAO {

    @Insert
     Single<Long> insert(User user);

    @Query("SELECT * FROM USER WHERE id =:id")
    Single<User> getUser(int id);


}
