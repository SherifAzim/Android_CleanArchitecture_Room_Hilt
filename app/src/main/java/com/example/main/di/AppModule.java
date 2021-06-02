package com.example.main.di;




import android.content.Context;

import com.example.data.UserDatabase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;

import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class AppModule {

    @Provides
    UserDatabase userDatabase(@ApplicationContext Context context){

        return UserDatabase.getInstance(context);
    }

}
