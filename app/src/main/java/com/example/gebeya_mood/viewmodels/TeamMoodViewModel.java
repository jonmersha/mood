package com.example.gebeya_mood.viewmodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.gebeya_mood.repo.team_moods_repo.TeamMoodApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TeamMoodViewModel implements Parcelable {

    private static final String BaseUrl = "https://stark-peak-15799.herokuapp.com/";
    private static TeamMoodViewModel teamMoodViewModel;

    String teamId, teamName, emotion, date, teamTotal;
    int emoji;
    Retrofit retrofit;

    public TeamMoodViewModel(String teamId, String teamName, String emotion, String date, String teamTotal) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.emotion = emotion;
        this.date = date;
        this.emoji = emoji;
        this.teamTotal = teamTotal;
    }

    private TeamMoodViewModel(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public TeamMoodViewModel(String emotion, String date, String teamTotal) {
        this.emotion = emotion;
        this.date = date;
        this.teamTotal = teamTotal;
        this.emoji = emoji;
    }


   /* protected TeamMoodViewModel(Parcel in) {
        teamId = in.readString();
        teamName = in.readString();
        emotion = in.readString();
        date = in.readString();
        teamTotal = in.readString();
        emoji = in.readInt();
    }*/

    public static final Creator<TeamMoodViewModel> CREATOR = new Creator<TeamMoodViewModel>() {
        @Override
        public TeamMoodViewModel createFromParcel(Parcel in) {
            return new TeamMoodViewModel();
        }

        @Override
        public TeamMoodViewModel[] newArray(int size) {
            return new TeamMoodViewModel[size];
        }
    };

    public int getEmoji() {
        return emoji;
    }

    public void setEmoji(int emoji) {
        this.emoji = emoji;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getTeamTotal() {
        return teamTotal;
    }

    public void setTeamTatal(String team) {
        this.teamTotal = team;
    }

    public void setTeamId(String userId) {
        this.teamId = userId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(teamId);
        dest.writeString(teamName);
        dest.writeString(emotion);
        dest.writeString(date);
        dest.writeString(teamTotal);
        dest.writeInt(emoji);
    }

    public static synchronized TeamMoodViewModel getInstance(){
        if(teamMoodViewModel == null){
            teamMoodViewModel = new TeamMoodViewModel();
        }
        return teamMoodViewModel;
    }

    public TeamMoodApiService getTeamService(){
        return retrofit.create(TeamMoodApiService.class);
    }
}
