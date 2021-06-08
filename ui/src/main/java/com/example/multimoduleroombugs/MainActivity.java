package com.example.multimoduleroombugs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.domain.models.UserModel;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
//    @Inject
//    public UserRepo userRepo;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

         mainViewModel.insertUser(new UserModel("fawzy", 45));

        mainViewModel.getUserById(1)
                .subscribe(new SingleObserver<UserModel>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull UserModel userModel) {
                        Log.d(TAG, "onCreate: User (1) = " + userModel.getName() +", "+ userModel.getAge());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });

    }
}