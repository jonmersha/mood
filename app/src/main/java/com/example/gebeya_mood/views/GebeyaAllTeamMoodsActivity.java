package com.example.gebeya_mood.views;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.viewmodels.UserMoodViewModel;
import com.example.gebeya_mood.adapters.UserMoodsAdapter;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class GebeyaAllTeamMoodsActivity extends BaseActivity {
    private RecyclerView moodRecyclerView;
    private UserMoodsAdapter userMoodsAdapter;
    private UserMoodViewModel userMoodViewModel;
    private List<UserMood> userMoods;
    private Context context;
    public static final int activityNum = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebeya_all_team_mood);
        ButterKnife.bind(this);
       // setBottomNavView();

        userMoods = new ArrayList<>();
        userMoodViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserMoodViewModel.class);

        // USER MOOD ADAPTER AND MODEL VIEW TO POPULATE DATA HERE

       /* userMoodsAdapter = new UserMoodsAdapter(this, userMoods);
        moodRecyclerView.setAdapter(userMoodsAdapter);
        moodRecyclerView.setLayoutManager(new LinearLayoutManager(this));*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mood_promt_menu, menu);
        getMenuInflater().inflate(R.menu.my_moods_menu, menu);
        getMenuInflater().inflate(R.menu.admin_data_set, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.moodsPromptIcon:
                Intent intentPrompt = new Intent(GebeyaAllTeamMoodsActivity.this, MoodPromptActivity.class);
                startActivity(intentPrompt);
                return true;
            case R.id.my_mood_history:
                Intent intentMoods = new Intent(GebeyaAllTeamMoodsActivity.this, UserMoodsActivity.class);
                startActivity(intentMoods);
                return true;
            case R.id.adminDataSetIcon:
                Intent intentAdminView = new Intent(GebeyaAllTeamMoodsActivity.this, AdminActivity.class);
                startActivity(intentAdminView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
