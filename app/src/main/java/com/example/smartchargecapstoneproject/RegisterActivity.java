package com.example.smartchargecapstoneproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener /*implements View.OnClickListener*/{
    private EditText fullName, emailId, password;
    private Button btnSignUp, registerBack;
    private FirebaseAuth fAuth;
    //FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    //private DatabaseReference root = db.getReference().child("users");
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();

        registerBack = (Button) findViewById(R.id.registerBack);
        registerBack.setOnClickListener(this);


        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);

        fullName = (EditText) findViewById(R.id.etFullName);
        emailId = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPasswordRegister1);

        databaseReference = FirebaseDatabase.getInstance().getReference("User");



        //databaseReference= FirebaseDatabase.getInstance().getReference().child("UsersData");
        //databaseReference= FirebaseDatabase.getInstance().getReference("users"));

        /*btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //rootNode = FirebaseDatabase.getInstance();
                //databaseReference= rootNode.getReference();
                //databaseReference.setValue("First data");

                String name = fullName.getText().toString().trim();
                String email = emailId.getText().toString().trim();
                String pwd = password.getText().toString().trim();

                if(name.isEmpty()) {
                    fullName.setError("Please enter name");
                    fullName.requestFocus();
                }
                else if(email.isEmpty()) {
                    emailId.setError("Please enter email");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()) {
                    password.setError("Please enter password");
                    password.requestFocus();
                }


                *//*else{
                    HashMap<String,String> hashMap = new HashMap<>();
                    //hashMap.put("userId", userId);
                    hashMap.put("fullName", name);
                    hashMap.put("email", email);
                    hashMap.put("password", pwd);

                    root.push().setValue(hashMap);
                }*//*

                else {
                    fAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "Sign Up Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            }

                            else {
                                register(name, email, pwd);
                                Toast.makeText(RegisterActivity.this, "Sign Up successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                                *//*HashMap<String,String> hashMap = new HashMap<>();
                                hashMap.put("userId", userId);
                                hashMap.put("fullName", name);
                                hashMap.put("email", email);
                                hashMap.put("password", pwd);

                                root.push().setValue(hashMap);*//*


                            }
                        }
                    });
                }

            }
        });

    }*/




/*    private void register(String name, String email, String pwd) {

        fAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    //UsersData usersData = new UsersData(name,email,pwd);
                    FirebaseUser rUser = fAuth.getCurrentUser();
                    assert rUser != null;
                    String userId = rUser.getUid();
                    FirebaseDatabase.getInstance().getReference("Users")
                            //.child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).setValue(rUser);
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(rUser);
                    //databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId);
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("userId", userId);
                    hashMap.put("fullName", name);
                    hashMap.put("email", email);
                    hashMap.put("password", pwd);
                    //hashMap.put("imageURL", "default");
                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else{
                    Toast.makeText(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });*/
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerBack:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btnSignUp:
                btnSignUp();
                break;
        }

    }

    private void btnSignUp() {
        String etFullName = fullName.getText().toString().trim();
        String etEmail = emailId.getText().toString().trim();
        String etPasswordRegister1 = password.getText().toString().trim();
        if(etFullName.isEmpty()) {
            fullName.setError("Please enter name");
            fullName.requestFocus();
            return;
        }
        if(etEmail.isEmpty()) {
            emailId.setError("Please enter email");
            emailId.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(etEmail).matches()){
            emailId.setError("Please provide valid email");
            emailId.requestFocus();
            return;
        }
        if(etPasswordRegister1.isEmpty()) {
            password.setError("Please enter password");
            password.requestFocus();
            return;
        }
        if(etPasswordRegister1.length() < 6){
            password.setError("Min password length should be 6 characters");
            password.requestFocus();
            return;
        }

        fAuth.createUserWithEmailAndPassword(etEmail,etPasswordRegister1)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            User user = new User(etFullName, etEmail);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterActivity.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                    }

                                }
                            });
                        }else{
                            Toast.makeText(RegisterActivity.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}