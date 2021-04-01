package com.example.smartchargecapstoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    public CardView homeCard, roomsCard, analyticsCard, historyCard, devicesCard, settingsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        homeCard = (CardView) findViewById(R.id.homeCard);
        roomsCard = (CardView) findViewById(R.id.roomsCard);
        analyticsCard = (CardView) findViewById(R.id.analyticsCard);
        historyCard = (CardView) findViewById(R.id.historyCard);
        devicesCard = (CardView) findViewById(R.id.devicesCard);
        settingsCard = (CardView) findViewById(R.id.settingsCard);

        homeCard.setOnClickListener(this);
        roomsCard.setOnClickListener(this);
        analyticsCard.setOnClickListener(this);
        historyCard.setOnClickListener(this);
        devicesCard.setOnClickListener(this);
        settingsCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.homeCard :
                i = new Intent(this, Home.class);
                startActivity(i);
                break;

            case R.id.roomsCard :
                i = new Intent(this, Rooms.class);
                startActivity(i);
                break;

            case R.id.analyticsCard :
                i = new Intent(this, Analytics.class);
                startActivity(i);
                break;

            case R.id.historyCard :
                i = new Intent(this, History.class);
                startActivity(i);
                break;

            case R.id.devicesCard :
                i = new Intent(this, Devices.class);
                startActivity(i);
                break;

            case R.id.settingsCard :
                i = new Intent(this, Settings.class);
                startActivity(i);
                break;
        }

    }
}