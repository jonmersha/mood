package com.example.gebeya_mood.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.gebeya_mood.App;

import retrofit2.Retrofit;

public class CreateUserViewModel extends AndroidViewModel {
    Retrofit retrofit;
    public CreateUserViewModel(@NonNull Application application) {
        super(application);
        retrofit=((App)application).getRetrofit();
    }
}
