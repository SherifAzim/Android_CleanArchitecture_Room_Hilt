package com.example.multimoduleroombugs;

import android.util.Log;


import androidx.lifecycle.ViewModel;

import com.example.domain.UserModel;
import com.example.domain.repos.UserRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";

   private final UserRepo userRepo;


   @Inject
    public MainViewModel(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void insertUser(UserModel userModel){

        userRepo.insertUser(userModel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Long aLong) {
                        Log.d(TAG, "onSuccess: " + aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });
    }
}
