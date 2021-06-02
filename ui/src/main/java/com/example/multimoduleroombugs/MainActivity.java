package com.example.multimoduleroombugs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.domain.UserModel;
import com.example.domain.repos.UserRepo;

import org.reactivestreams.Subscription;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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


       // UserRepo userRepo = new UserRepo(getApplicationContext());
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.insertUser(new UserModel("magdy", 3));

    }
}