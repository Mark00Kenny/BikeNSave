package com.example.bikensave;
// https://www.youtube.com/watch?v=9QOg8R8ol1w    READ ME      (Coding with Tea Creating a profile)

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;


public class UserProfile extends AppCompatActivity {

    //Setting variables for XML Hooks
    TextInputLayout fullName, userName, Email, Password, BikeNo;
    TextView fullNameLabel, userLabel;

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        imageView = findViewById(R.id.bike_pic);

        //Hooks for XML to load and edit
        fullName = findViewById(R.id.full_NameProfile);
        userName = findViewById(R.id.username_Profile);
        Email = findViewById(R.id.emailProfile);
        Password = findViewById(R.id.password_Profile);
        BikeNo = findViewById(R.id.bikeSerial_Profile);
        fullNameLabel = findViewById(R.id.full_Name);
        userLabel = findViewById(R.id.userLabel);

        //Show The data from Firebase
        showAllUserData();

    }
    //Get the data from the intent
    private void showAllUserData() {

        Intent intent = getIntent();
        String user_username = intent.getStringExtra("userName");
        String user_fullName = intent.getStringExtra("fullName");
        String user_Email = intent.getStringExtra("userEmail");
        String user_Password = intent.getStringExtra("userPassword");
        String user_Bike = intent.getStringExtra("userBike");

        fullNameLabel.setText(user_fullName);
        userLabel.setText(user_username);
        fullName.getEditText().setText(user_fullName);
        userName.getEditText().setText(user_username);
        Email.getEditText().setText(user_Email);
        Password.getEditText().setText(user_Password);
        BikeNo.getEditText().setText(user_Bike);


    }

    // Allow user to upload their bike picture
    public void uploadPicture(View view) {
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (imageTakeIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
        }

    }
    @Override
            protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }

    }




}