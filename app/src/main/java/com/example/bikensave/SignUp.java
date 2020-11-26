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
    Button CallSignIn, CreateAccount;
    TextInputLayout FullName, UserName, UserEmail, UserPassword;

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
        CreateAccount = findViewById(R.id.create_account);
        CallSignIn = findViewById(R.id.backToSign);

        /*
        //Error Handling and setting restrictions
        private Boolean validateName() {
            String val = FullName.getEditText().getText().toString();

            if (val.isEmpty()) {
                FullName.setError("Field cannot be empty");
                return false;
            }
            else{
                FullName.setError(null);
                return true;
            }
        }
        */
        //When clicked the Create Account button will write to Firebase
        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                //Linking Text Fields To Values
                String name = FullName.getEditText().getText().toString();
                String username = UserName.getEditText().getText().toString();
                String email = UserEmail.getEditText().getText().toString();
                String password = UserPassword.getEditText().getText().toString();

                //Setting the new Users
                UserHelperClass setUsers = new UserHelperClass(name,username,email,password);

                //Saving to Firebase and setting the Unique ID to Username.
                reference.child(username).setValue(setUsers);
            }
        });  // End of method for creating a new user.

        CallSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this,LoginBikeNSave.class);
                startActivity(intent);
            }
        });
    }


}