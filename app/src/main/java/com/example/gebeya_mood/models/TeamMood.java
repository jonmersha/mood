package com.example.gebeya_mood.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class TeamMood {

    @PrimaryKey
    @NonNull
    public String teamId;

    @NonNull
    public String emotion;

    @NonNull
    public String teamName;

    @NonNull
    public String teamTotal; // total number of members

    @NonNull
    @ColumnInfo(name = "created_at")
    public String date;


}
