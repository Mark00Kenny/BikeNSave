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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UserProfile extends AppCompatActivity {

    //Setting variables for XML Hooks
    TextInputLayout fullName, userName, Email, Password, BikeNo;
    TextView fullNameLabel, userLabel;

    //Global  Variables to hold the data of users for the profile
    String _USERNAME, _FULLNAME, _EMAIL, _BIKE, _PASSWORD;

    DatabaseReference reference;

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        imageView = findViewById(R.id.bike_pic);
        reference = FirebaseDatabase.getInstance().getReference("users");

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

    //Get the data from the intent in the login page(Posting between pages)
    private void showAllUserData() {

        Intent intent = getIntent();
        _USERNAME = intent.getStringExtra("userName");
        _FULLNAME = intent.getStringExtra("fullName");
        _EMAIL = intent.getStringExtra("userEmail");
        _PASSWORD = intent.getStringExtra("userPassword");
        _BIKE = intent.getStringExtra("userBike");

        fullNameLabel.setText(_FULLNAME);
        userLabel.setText(_USERNAME);
        fullName.getEditText().setText(_FULLNAME);
        Email.getEditText().setText(_EMAIL);
        Password.getEditText().setText(_PASSWORD);
        BikeNo.getEditText().setText(_BIKE);


    }

    // Allow user to upload their bike picture
    public void uploadPicture(View view) {
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (imageTakeIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }

    }

    //Creating the update function so user can change some details. User cannot change username as it is unique
    public void update_user(View view) {
        if (isFullNameChanged() || isPasswordChanged() || isBikeChanged() || isEmailChanged()) {
            Toast.makeText(this, "Record has been updated", Toast.LENGTH_LONG).show();

        }
        else Toast.makeText(this, "Data remains the same. Update aborted", Toast.LENGTH_LONG).show();

    }

    //If these fields are changed DataBase will be called and updated
    private boolean isFullNameChanged() {
        if (!_FULLNAME.equals(fullName.getEditText().getText().toString())) {

            reference.child(_USERNAME).child("fullName").setValue(fullName.getEditText().getText().toString());
            _FULLNAME = fullName.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordChanged() {
        if (!_PASSWORD.equals(Password.getEditText().getText().toString())) {

            reference.child(_USERNAME).child("userPassword").setValue(Password.getEditText().getText().toString());
            _PASSWORD = Password.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }


    private boolean isBikeChanged() {
        if (!_BIKE.equals(BikeNo.getEditText().getText().toString())) {

            reference.child(_USERNAME).child("userBike").setValue(BikeNo.getEditText().getText().toString());
            _BIKE = BikeNo.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!_EMAIL.equals(Email.getEditText().getText().toString())) {

            reference.child(_USERNAME).child("userEmail").setValue(Email.getEditText().getText().toString());
            _EMAIL = Email.getEditText().getText().toString();
            return true;
        } else {
            return false;
        }
    }


}