package com.example.smartchargecapstoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.ArrayList;

public class History extends AppCompatActivity {

    Button backBtn;


    RecyclerView recyclerView;
    List<HistoryList> historyListList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = findViewById(R.id.historyListRecyclerView);

        initData();
        setRecyclerView();

        backBtn = findViewById(R.id.historyBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(History.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setRecyclerView() {
        HistoryListAdapter historyListAdapter = new HistoryListAdapter(historyListList);
        recyclerView.setAdapter(historyListAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        historyListList = new ArrayList<>();

        historyListList.add(new HistoryList("'Bathroom' outlet has been successfully configured!", "No Action"));
        historyListList.add(new HistoryList("'Garage' outlet has been disconnected", "Ensure smart outlet is securely connected to the wall outlet"));
        historyListList.add(new HistoryList("'Lakehouse' outlet has lost power!", "Ensure smart outlet is securely connected to the wall outlet"));
        historyListList.add(new HistoryList(" 'Kitchen' outlet has been manually powered OFF", "No action needed"));
        historyListList.add(new HistoryList(" 'Office' outlet has been manually powered ON", "No action needed"));
        historyListList.add(new HistoryList(" 'Office' room has been created", "No action needed"));
        historyListList.add(new HistoryList(" New User has been added to this account", "No action needed"));

    }
}