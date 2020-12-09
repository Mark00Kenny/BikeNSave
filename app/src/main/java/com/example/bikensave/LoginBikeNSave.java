package com.example.bikensave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.bikensave.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginBikeNSave extends AppCompatActivity {

    Button callSignUp;
    TextInputLayout password;
    TextInputLayout userName;

    @Override //Code to facilitate moving to User creation
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_bike_n_save);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);

        //Calling the sign up for unregistered users.
        callSignUp = findViewById(R.id.sign_up);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginBikeNSave.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    // Validating the User's Username as this is my primary key
    //Error Handling For UserName
    private Boolean validateUsername() {
        String val = userName.getEditText().getText().toString();

        if (val.isEmpty()) {
            userName.setError("Please Enter a valid Username");
            return false;
        } else {
            userName.setError(null);
            userName.setErrorEnabled(false);
            return true;
        }
    }

    //Error Handling for Password
    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();

        if (val.isEmpty()) {
            password.setError("Password Needed");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    public void login_User(View view) {
        //Validates User and allows a login if details are correct.
        if (!validateUsername() | !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }

    //Reading From Firebase
    private void isUser() {
        final String userEnteredUsername = userName.getEditText().getText().toString().trim();
        final String userEnteredPassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        // Query The user from Firebase
        Query checkUser = reference.orderByChild("userName").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            //If data exists get it from string
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    userName.setError(null);
                    userName.setErrorEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("userPassword").getValue(String.class);

                    if (passwordFromDB.equals(userEnteredPassword)) {

                        userName.setError(null);
                        userName.setErrorEnabled(false);

                        String userNameFromDB = dataSnapshot.child(userEnteredUsername).child("userName").getValue(String.class);
                        String fullNameFromDB = dataSnapshot.child(userEnteredUsername).child("fullName").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("userEmail").getValue(String.class);
                        String bikeFromDB = dataSnapshot.child(userEnteredUsername).child("userBike").getValue(String.class);

                        // Load the Profile Screen
                        Intent intent = new Intent(getApplicationContext(), UserProfile.class);

                        intent.putExtra("userName", userNameFromDB);
                        intent.putExtra("fullName", fullNameFromDB);
                        intent.putExtra("userEmail", emailFromDB);
                        intent.putExtra("userBike", bikeFromDB);
                        intent.putExtra("userPassword", passwordFromDB);

                        startActivity(intent);
                    } else {
                        password.setError("Incorrect Password");
                        password.requestFocus();

                    }
                } else {
                    userName.setError("Username does not exist");
                    userName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
