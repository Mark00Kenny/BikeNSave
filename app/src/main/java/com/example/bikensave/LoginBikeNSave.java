package com.example.bikensave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bikensave.R;

public class LoginBikeNSave extends AppCompatActivity {

    Button callSignUp, login_user;

    @Override //Code to facilitate moving to User creation
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_bike_n_save);

        //Calling the sign up for unregistered users.
        callSignUp = findViewById(R.id.sign_up);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginBikeNSave.this,SignUp.class);
                startActivity(intent);
            }
        });
    }

    // Validating the User's Username as this is my primary key
    /*
    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        //Error Handling
        if (val.isEmpty()) {
            username.setError("Field Cannot be Empty");
            return false;
        }
        else if (val.length() >= 15) {
            username.setError("Username too long");
            return false;
        }
        else if (!val.matches(noWhiteSpace)) {
            username.setError("White Spaces are not allowed");
            return false;
        }
        else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    public void loginUser(View view) {
        //Validates User and allows a login if details are correct.
        if (!validateUsername() | !validatePassword()) {
            return;
        }
    }
*/
}
