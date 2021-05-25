package com.example.smartchargecapstoneproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class Rooms extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    Button backBtn, addBtn;
    RecyclerView recyclerView;

    //RecyclerView.Adapter roomsListAdapter;

    roomsListAdapter roomsListAdapter;
    RecyclerView.LayoutManager roomsLayoutManager;
    DatabaseReference databaseReference;
    ArrayList<RoomList> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);


        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("rooms");

        //databaseReference=FirebaseDatabase.getInstance().getReference().child("rooms");
        //databaseReference=FirebaseDatabase.getInstance().getReference("Users").child("rooms");

        //databaseReference=FirebaseDatabase.getInstance().getReference("RoomDescription");

        databaseReference.keepSynced(true);

        //recyclerView=(RecyclerView)findViewById(R.id.roomsListRecyclerView);

        recyclerView = findViewById(R.id.roomsListRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        roomsListAdapter = new roomsListAdapter(this,list);




        /*ArrayList<ExampleRoom> exampleRoomList = new ArrayList<>();
        exampleRoomList.add(new ExampleRoom("Room Name","Room Description"));*/





        roomsLayoutManager = new LinearLayoutManager(this);
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this));*/



        //roomsListAdapter = new roomsListAdapter(exampleRoomList);



        recyclerView.setLayoutManager(roomsLayoutManager);
        recyclerView.setAdapter(roomsListAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    RoomList roomList = dataSnapshot.getValue(RoomList.class);
                    list.add(roomList);
                }
                roomsListAdapter.setItems(list);
                roomsListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /*setRecyclerView();*/



        backBtn = findViewById(R.id.roomsBackBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Rooms.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        addBtn = findViewById(R.id.addRoomBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String roomName, String roomDescription) {

    }

/*    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<RoomList, RoomListViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<RoomList, RoomListViewHolder>
                (RoomList.class,R.layout.recycler_view_rooms,RoomListViewHolder.class,databaseReference) {
            @NonNull
            @Override
            public RoomListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            protected void onBindViewHolder(@NonNull RoomListViewHolder viewHolder, int i, @NonNull RoomList roomList) {
                viewHolder.setRoomName(roomList.getRoomName());
                viewHolder.setRoomDescription(roomList.getRoomDescription());
            }

            @Override
            protected void populateViewHolder(RoomListViewHolder viewHolder, RoomList model, int position){
                viewHolder.setRoomName(model.getRoomName());
                viewHolder.setRoomDescription(model.getRoomDescription());

            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public static class RoomListViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public RoomListViewHolder(View view){
            super(view);
            mView=view;
        }
        public void setRoomName(String roomName ){
            TextView text_view_name=(TextView)mView.findViewById(R.id.text_view_name);
            text_view_name.setText(roomName);
        }
        public void setRoomDescription(String roomDescription){
            TextView text_description_name=(TextView)mView.findViewById(R.id.text_description_name);
            text_description_name.setText(roomDescription);
        }
    }*/

    /*private void setRecyclerView() {
        roomsListAdapter roomsListAdapter = new roomsListAdapter(roomListList);
        recyclerView.setAdapter(roomsListAdapter);
        recyclerView.setHasFixedSize(true);
    }*/





    /*@Override
    public void applyTexts(String roomName, String roomDescription){


    }*/



        /*addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rooms.this)
            }
        });*/
    }