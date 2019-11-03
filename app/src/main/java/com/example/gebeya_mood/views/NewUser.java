package com.example.gebeya_mood.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.pojos.CreateUserResponse;
import com.example.gebeya_mood.viewmodels.CreateUserViewModel;
import com.google.gson.JsonObject;

public class NewUser extends AppCompatActivity {


    private EditText tname;
    private EditText temail;
    private EditText tpassWord;
    private EditText tteam;
    private EditText tsex;
    private CreateUserViewModel createUserViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        tname=findViewById(R.id.user_name);
        temail=findViewById(R.id.user_email);
        tpassWord=findViewById(R.id.passWord);
        tteam=findViewById(R.id.team);
        tsex=findViewById(R.id.sex);

        createUserViewModel=new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(CreateUserViewModel.class);

    }

    public void cretteUsers(View v){
       // {"name":"yohannes","email":"jonmersha@gmail.com","password":"123joni","team":"Student","sex":"Male"}

       String name,email,pawword,team,sex;
        name=tname.getText().toString();
        email=temail.getText().toString();
        pawword=tpassWord.getText().toString();
        team=tteam.getText().toString();
        sex=tsex.getText().toString();


        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("email",email);
        jsonObject.addProperty("password",pawword);
        jsonObject.addProperty("team",team);
        jsonObject.addProperty("sex",sex);

        createUserViewModel.createUserAccount(jsonObject);
        createUserViewModel.getUserCreationResponse().observe(this, new Observer<CreateUserResponse>() {
            @Override
            public void onChanged(CreateUserResponse createUserResponse) {
                TextView result=findViewById(R.id.response);
                result.append("ID\t:"+createUserResponse.get_id());
                result.append("\nname\t:"+createUserResponse.getName());
                result.append("\nemail\t:"+createUserResponse.getEmail());
                result.append("\nTeam\t:"+createUserResponse.getTeam());
                result.append("\nGender\t:"+createUserResponse.getSex());
                result.append("\nUser Role\t:"+createUserResponse.getRole());


            }
        });
    }
}
