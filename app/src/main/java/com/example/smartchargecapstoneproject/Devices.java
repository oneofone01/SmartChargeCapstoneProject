package com.example.smartchargecapstoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Devices extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DeviceList> deviceListList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);

        recyclerView = findViewById(R.id.deviceListRecyclerView);

        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        DeviceListAdapter deviceListAdapter = new DeviceListAdapter(deviceListList);
        recyclerView.setAdapter(deviceListAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {

        deviceListList = new ArrayList<>();

        deviceListList.add(new DeviceList(" Bathroom Outlet", " 15 Hours", " 1115 Watts/Hr", " ~115 Watts", " $5.50", " $52.14"));
        deviceListList.add(new DeviceList(" Garage Outlet", " 22 Hours", " 2134 Watts/Hr", " ~300 Watts", " $5.51", " $52.65"));
        deviceListList.add(new DeviceList(" Kitchen Outlet", " 17 Hours", " 1700 Watts/Hr", " ~174 Watts", " $4.75", " $50.87"));
        deviceListList.add(new DeviceList(" Bedroom Outlet", " 35 Hours", " 2500 Watts/Hr", " ~621 Watts", " $8.21", " $100.10"));
        deviceListList.add(new DeviceList(" Office Outlet", " 12 Hours", " 1250 Watts/Hr", " ~250 Watts", " $3.50", " $35.27"));
        deviceListList.add(new DeviceList(" Pool House Outlet", " 5 Hours", " 155 Watts/Hr", " ~96 Watts", " $2.90", " $22.00"));
        deviceListList.add(new DeviceList(" Game Room Outlet", " 19 Hours", " 1520 Watts/Hr", " ~326 Watts", " $5.11", " $45.52"));

    }
}