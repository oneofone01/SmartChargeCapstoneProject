package com.example.smartchargecapstoneproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.example.smartchargecapstoneproject.data.DataProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity {

    private Button backBtn;
    private TextView userNameDisplay;
    private FirebaseAuth fAuth;
    //private FirebaseUser firebaseUser;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private CircleImageView accountBtn;
    private String userID;
    //private ActionBar actionBar;


    private ViewPager viewPagerRooms;
    private ViewPager viewPagerDevices;


    private ArrayList<MyRoomsHomeCardModel> modelArrayList = new ArrayList<>();

    //private ArrayList<MyDevicesHomeCardModel> modelArrayList2 = new ArrayList<>();

    private MyRoomsHomeCardAdapter myRoomsHomeCardAdapter;

    private MyDevicesHomeCardAdapter myDevicesHomeCardAdapter;

    //RecyclerView.Adapter adapter;
    //List<DeviceList> deviceListList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initData();
        //setViewPagerDevices();


        /*        actionBar = getSupportActionBar();

        //init UI views
        viewPagerRooms = findViewById(R.id.viewPagerRooms);
        loadCards();

        //set viewpager change listener
        viewPagerRooms.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //
                String roomName = modelArrayList.get(position).getRoomName();
                actionBar.setTitle(roomName);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/

        //recyclerView = findViewById(R.id.recycler_view);

        //Integer[] langLogo = {R}

        accountBtn = findViewById(R.id.myHomeAccountButton);
        backBtn = findViewById(R.id.MyHomeBack);

        viewPagerDevices = findViewById(R.id.viewPagerDevices);



        //TextView fullName = findViewById(R.id.userNameDisplay);
        //set


        //fullName = findViewById(R.id.userNameDisplay);
        //fAuth = FirebaseAuth.getInstance();
        //user = fAuth.getCurrentUser();
        user = FirebaseAuth.getInstance().getCurrentUser();
        /*databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());*/
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        final TextView nameTextView = (TextView) findViewById(R.id.userNameDisplay);

        databaseReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String userNameDisplay = userProfile.etFullName;

                    nameTextView.setText(userNameDisplay);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Home.this, "Something wrong happened!", Toast.LENGTH_LONG).show();

            }
        });

        /*databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {

                    //UsersData usersData = new UsersData(); //dataSnapshot.getValue(UsersData.class);
                    //UsersData usersData = dataSnapshot.getValue(UsersData.class);
                    User user = dataSnapshot.getValue(User.class);
                    //assert usersData != null;
                    assert user !=null;
                    //fullName.setFullName(usersData.getFullName());

                    //45:00 in https://www.youtube.com/watch?v=BHT8hCtOP1U
                    *//*if (usersData.getImageURL().equals("default")) {
                        accountBtn.setImageLevel(R.drawable.ic_baseline_account_circle_24);
                    } else {
                        Glide.with(getApplicationContext()).load(usersData.getImageURL()).into(accountBtn);
                    }*//*

                } catch(Exception e){
                    System.out.println("HDHSDKLSDJLKF111");
                    System.out.println(e.getMessage());
                    e.getStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Home.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });*/

        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Account.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainMenuActivity.class);
                startActivity(intent);

            }
        });

        // viewPager for ROOMS
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("rooms");

        viewPagerRooms = findViewById(R.id.viewPagerRooms);
        //viewPagerDevices = findViewById(R.id.viewPagerDevices);
        myRoomsHomeCardAdapter = new MyRoomsHomeCardAdapter(this, new ArrayList<>());
        viewPagerRooms.setAdapter(myRoomsHomeCardAdapter);

        /*int pagerPadding = 16;
        viewPagerRooms.setClipToPadding(false);
        viewPagerRooms.setPadding(pagerPadding, 0, pagerPadding, 0);*/

        setViewPagerDevices();



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelArrayList.clear();
                //modelArrayList2.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    RoomList roomList = dataSnapshot.getValue(RoomList.class);

                    //DeviceList deviceList = dataSnapshot.getValue(DeviceList.class);

                    assert roomList != null;
                    MyRoomsHomeCardModel cardModel = new MyRoomsHomeCardModel(roomList.getRoomName());

                    //MyDevicesHomeCardModel cardModel1 = new MyDevicesHomeCardModel(deviceList.getDevice_name());
                    modelArrayList.add(cardModel);
                    //modelArrayList2.add(cardModel1);
                }
                myRoomsHomeCardAdapter.setArrayItems(modelArrayList);
                myRoomsHomeCardAdapter.notifyDataSetChanged();

                //myDevicesHomeCardAdapter.setArrayItems(modelArrayList2);
                //myDevicesHomeCardAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }



        });
        // viewPager for DEVICES

    }

    private void setViewPagerDevices() {
//        MyDevicesHomeCardAdapter myDevicesHomeCardAdapter = new MyDevicesHomeCardAdapter(deviceListList);
//        DeviceListAdapter myDevicesHomeCardAdapter = new DeviceListAdapter(deviceListList);

        myDevicesHomeCardAdapter = new MyDevicesHomeCardAdapter(this, DataProvider.getDeviceHomeCardList());
        viewPagerDevices.setAdapter(myDevicesHomeCardAdapter);
    }
}

    /*
    private void initData() {

        deviceListList = new ArrayList<>();

        deviceListList.add(new DeviceList(" Bathroom Outlet", "Online For: 15 Hours", "Average Wattage Consumed: 1115 W/Hr", "Current Wattage Usage: ~115 Watts", "Estimated Daily Energy Cost: $5.50", "Estimated Monthly Energy Cost: $52.14"));
        deviceListList.add(new DeviceList(" Garage Outlet", "Online For: 22 Hours", "Average Wattage Consumed: 2134 W/Hr", "Current Wattage Usage: ~300 Watts", "Estimated Daily Energy Cost: $5.51", "Estimated Monthly Energy Cost: $52.65"));
        deviceListList.add(new DeviceList(" Kitchen Outlet", "Online For: 17 Hours", "Average Wattage Consumed: 1700 W/Hr", "Current Wattage Usage: ~174 Watts", "Estimated Daily Energy Cost: $4.75", "Estimated Monthly Energy Cost: $50.87"));
        deviceListList.add(new DeviceList(" Bedroom Outlet", "Online For: 35 Hours", "Average Wattage Consumed: 2500 W/Hr", "Current Wattage Usage: ~621 Watts", "Estimated Daily Energy Cost: $8.21", "Estimated Monthly Energy Cost: $100.10"));
        deviceListList.add(new DeviceList(" Office Outlet", "Online For: 12 Hours", "Average Wattage Consumed: 1250 W/Hr", "Current Wattage Usage: ~250 Watts", "Estimated Daily Energy Cost: $3.50", "Estimated Monthly Energy Cost: $35.27"));
        deviceListList.add(new DeviceList(" Pool House Outlet", "Online For: 5 Hours", "Average Wattage Consumed: 155 W/Hr", "Current Wattage Usage: ~96 Watts", "Estimated Daily Energy Cost: $2.90", "Estimated Monthly Energy Cost: $22.00"));
        deviceListList.add(new DeviceList(" Game Room Outlet", "Online For: 19 Hours", "Average Wattage Consumed: 1520 W/Hr", "Current Wattage Usage: ~326 Watts", "Estimated Daily Energy Cost: $5.11", "Estimated Monthly Energy Cost: $45.52"));
    }*/


/*    private void loadCards() {
        //init list
        modelArrayList = new ArrayList<>();

        //add items to list
        modelArrayList.add(new MyRoomsHomeCardModel(
                "Garage"));
        modelArrayList.add(new MyRoomsHomeCardModel(
                "Bathroom"));

        //setup adapter
        myRoomsHomeCardAdapter = new MyRoomsHomeCardAdapter(this,modelArrayList);
        //set adapter to view pager
        viewPagerRooms.setAdapter(myRoomsHomeCardAdapter);
        //set default padding from left to right
        viewPagerRooms.setPadding(100, 0, 100,0);

    }*/

/*    private void phoneRecycler() {

        //All Gradients
        GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        GradientDrawable gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        phoneRecycler.setHasFixedSize(true);
        phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<phonehelper> phonelocations = new ArrayList<>();
        *//*phonelocations.add(new phonehelper(gradient1, R.drawable.samsung, "Samsung"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.vivo, "Vivo"));
        phonelocations.add(new phonehelper(gradient2, R.drawable.apple, "Apple"));
        phonelocations.add(new phonehelper(gradient4, R.drawable.realme, "Realme"));
        phonelocations.add(new phonehelper(gradient2, R.drawable.poco, "Poco"));*//**//*


        adapter = new adapterphone(phonelocations, this);
        phoneRecycler.setAdapter(adapter);*//*
    }*/

/*    @Override
    public void onphoneListClick(int clickedItemIndex) {
        Intent mIntent;
        switch (clickedItemIndex){
            case 0: //first item in Recycler view
                mIntent  = new Intent(Home.this, garage.class);
                startActivity(mIntent);
                break;
            case 1: //second item in Recycler view
                mIntent = new Intent(Home.this, bathroom.class);
                startActivity(mIntent);
                break;
            case 2: //third item in Recycler view
                mIntent = new Intent(Home.this, livingroom.class);
                startActivity(mIntent);
                break;
            case 3: //third item in Recycler view
                mIntent = new Intent(Home.this, bedroom.class);
                startActivity(mIntent);
                break;
            case 4: //third item in Recycler view
                mIntent = new Intent(Home.this, basement.class);
                startActivity(mIntent);
                break;

        }
    }*/
