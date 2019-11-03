package com.example.gebeya_mood.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.pojos.CreateUserResponse;
import com.example.gebeya_mood.repo.users.UserApiService;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreateUserViewModel extends AndroidViewModel {

    private MutableLiveData<CreateUserResponse> userCreationResponse;
    Retrofit retrofit;
    public CreateUserViewModel(@NonNull Application application) {
        super(application);
        retrofit=((App)application).getRetrofit();
        userCreationResponse=new MutableLiveData<>();
    }

    public void createUserAccount(JsonObject userinformation){
        UserApiService userService=retrofit.create(UserApiService.class);
        userService.createUser(userinformation).enqueue(new Callback<CreateUserResponse>() {
            @Override
            public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
                userCreationResponse.setValue(response.body());

            }

            @Override
            public void onFailure(Call<CreateUserResponse> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<CreateUserResponse> getUserCreationResponse() {
        return userCreationResponse;
    }
}
