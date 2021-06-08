package com.example.multimoduleroombugs;

import android.content.Context;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.example.domain.interactors.InsertUserUseCase;
import com.example.domain.models.UserModel;
import com.example.domain.interactors.GetUserByIdUseCase;


import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";


   private final GetUserByIdUseCase getUserById;
   private final InsertUserUseCase insertUserUseCase;
   private Context context;



   @Inject
    public MainViewModel(GetUserByIdUseCase getUserById,
                         InsertUserUseCase insertUserUseCase,
                         @ApplicationContext Context context) {

       this.getUserById = getUserById;
       this.insertUserUseCase = insertUserUseCase;
       this.context = context;
    }

    public void insertUser(UserModel userModel){

        insertUserUseCase.execute(userModel)
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

    public Single<UserModel> getUserById(int id){

      return getUserById.execute(id).subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());

    }
}
