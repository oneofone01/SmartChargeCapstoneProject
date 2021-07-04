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

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.example.smartchargecapstoneproject.HomeRoomCardHelperClasses.adapterphone;
//import com.example.smartchargecapstoneproject.HomeRoomCardHelperClasses.phonehelper;
import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity /*implements adapterphone.ListItemClickListener*/ {

    private Button backBtn;
    private TextView userNameDisplay;
    private FirebaseAuth fAuth;
    //private FirebaseUser firebaseUser;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private CircleImageView accountBtn;
    private String userID;
    private ActionBar actionBar;

    private ViewPager viewPagerRooms;
    private ViewPager viewPagerDevices;

    private ArrayList<MyRoomsHomeCardModel> modelArrayList = new ArrayList<>();
    private MyRoomsHomeCardAdapter myRoomsHomeCardAdapter;



    //RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

        // recycleView for ROOMS
        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("rooms");

        viewPagerRooms = findViewById(R.id.viewPagerRooms);
        myRoomsHomeCardAdapter = new MyRoomsHomeCardAdapter(this, new ArrayList<>());
        viewPagerRooms.setAdapter(myRoomsHomeCardAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelArrayList.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    RoomList roomList = dataSnapshot.getValue(RoomList.class);

                    MyRoomsHomeCardModel cardModel = new MyRoomsHomeCardModel(roomList.getRoomName());
                    modelArrayList.add(cardModel);
                }
                myRoomsHomeCardAdapter.setArrayItems(modelArrayList);
                myRoomsHomeCardAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}




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
//}