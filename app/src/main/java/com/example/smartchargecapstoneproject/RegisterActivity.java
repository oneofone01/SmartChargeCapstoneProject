package com.example.smartchargecapstoneproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText fullName, emailId, password;
    Button btnSignUp;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        fAuth = FirebaseAuth.getInstance();
        fullName = findViewById(R.id.etFullName);
        emailId = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPasswordRegister1);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if(email.isEmpty()) {
                    emailId.setError("Please enter email");
                    emailId.requestFocus();
                }
                else if(pwd.isEmpty()) {
                    password.setError("Please enter password");
                    password.requestFocus();
                }

                else if(email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Fields are empty!", Toast.LENGTH_SHORT);
                }
                else if(!(email.isEmpty() && pwd.isEmpty())) {
                    fAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this, "SignUp Unsuccessful, Please Try Again", Toast.LENGTH_SHORT);
                            }
                            else {
                                startActivity(new Intent(RegisterActivity.this,MainMenuActivity.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(RegisterActivity.this,"Error Occurred!",Toast.LENGTH_SHORT);
                }
            }
        });

    }
}