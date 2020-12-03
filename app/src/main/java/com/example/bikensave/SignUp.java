package com.example.bikensave;
// https://www.youtube.com/watch?v=aU8dWySoMOU             (Coding with Tea Sign up Screen)

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    //Variables for the Sign up
    Button CallSignIn;
    TextInputLayout FullName, UserName, UserEmail, UserPassword, UserBike;

    //Referencing the Database
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Hooks to the XML Design page
        FullName = findViewById(R.id.user_fullName);
        UserName = findViewById(R.id.user_username);
        UserEmail = findViewById(R.id.user_email);
        UserPassword = findViewById(R.id.user_password);
        UserBike = findViewById(R.id.user_bike);
        CallSignIn = findViewById(R.id.backToSign);
    }

    //Error Handling and setting restrictions and regex patterns

    private Boolean validateName() {
        String val = FullName.getEditText().getText().toString();

        if (val.isEmpty()) {
            FullName.setError("User Needs A Name");
            return false;
        } else {
            FullName.setError(null);
            FullName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUserName() {
        String val = UserName.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            UserName.setError("User Needs A Username");
            return false;
        } else if (val.length() >= 15) {
            UserName.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            UserName.setError("Spaces are Prohibited");
            return false;
        } else {
            UserName.setError(null);
            UserName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = UserEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            UserEmail.setError("User Needs An Email Address");
            return false;
        } else if (!val.matches(emailPattern)) {
            UserEmail.setError("Invalid Email");
            return false;
        } else {
            UserEmail.setError(null);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = UserPassword.getEditText().getText().toString();
        String passwordVal = "^" +

                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special symbol
                "(?=\\S+$)" +           //at least 1 digit
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            UserPassword.setError("User Needs A Password");
            return false;
        } else if (!val.matches(passwordVal)) {
            UserPassword.setError("Password not strong enough");
            return false;
        } else {
            UserPassword.setError(null);
            return true;
        }
    }

    private Boolean validateBike() {
        String val = UserBike.getEditText().getText().toString();

        if (val.isEmpty()) {
            UserBike.setError("User Needs to register their bike");
            return false;
        } else {
            UserBike.setError(null);
            return true;
        }
    }


    //When clicked the Create Account button will write to Firebase
    public void CreateAccount(View view) {

        //re-enforcing error handling if any fields are blank
        if (!validateName() | !validateUserName() | !validateEmail() | !validatePassword() |!validateBike())
            return;
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        //Linking Text Fields To Values
        String name = FullName.getEditText().getText().toString();
        String username = UserName.getEditText().getText().toString();
        String email = UserEmail.getEditText().getText().toString();
        String password = UserPassword.getEditText().getText().toString();
        String bike = UserBike.getEditText().getText().toString();

        //Setting the new Users
        UserHelperClass setUsers = new UserHelperClass(name, username, email, password, bike);

        //Saving to Firebase and setting the Unique ID to Username.
        reference.child(username).setValue(setUsers);
    }  // End of method for creating a new user.


}


