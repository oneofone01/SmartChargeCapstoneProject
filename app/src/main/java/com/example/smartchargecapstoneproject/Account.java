package com.example.smartchargecapstoneproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class Account extends AppCompatActivity {
    Button backBtn;
    private ImageView myProfilePicture;
    private FirebaseUser user;
    private FirebaseAuth fAuth;
    private DatabaseReference databaseReference;
    private CircleImageView accountBtn;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);




        backBtn = findViewById(R.id.accountBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this, Home.class);
                startActivity(intent);
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        final TextView nameTextView = (TextView) findViewById(R.id.nameParamAccount);
        final TextView nameTitleTextView = (TextView) findViewById(R.id.nametitle_textview);
        final TextView emailTextView = (TextView) findViewById(R.id.emailParamAccount);

        databaseReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile != null){
                    String userNameDisplay = userProfile.etFullName;
                    String emailDisplay = userProfile.etEmail;

                    nameTextView.setText(userNameDisplay);
                    nameTitleTextView.setText(userNameDisplay);
                    emailTextView.setText(emailDisplay);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        }
    }