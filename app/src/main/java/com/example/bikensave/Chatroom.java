package com.example.bikensave;

import android.view.View;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
// https://www.youtube.com/watch?v=tOBHyPEs3_M
// This video helped me build my chatrooms.

public class Chatroom extends AppCompatActivity {
    //Referencing the Database
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    //Setting my variables for sending and viewing messages
    EditText MessageBox;
    TextView MessageView;

    private String user_name, room_name;
    String temp_key;

    //Posting variables from previous activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        MessageBox = (EditText) findViewById(R.id.editText2);
        MessageView = (TextView) findViewById(R.id.textView);
        user_name = getIntent().getExtras().get("user_name").toString();
        room_name = getIntent().getExtras().get("room_name").toString();


        //Error handling for actionbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Setting refrence of chatroom to avoid showing users.
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("chatrooms").child(room_name);
        setTitle(" Room - " + room_name);


        //Allowing for database to send snapshots to allow data to be read in application.
        //Allows appending of snapshot too
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                append_chat(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    //Depending on which forum is chosen this allows the user
    // to be taken to a different chat option.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    //Correlates the user with the message that they have sent.
    //Allows for a one session experience which doesn't require log in.
    //Messages can be moderated in Firebase Console.
    public void send(View v) {
        Map<String, Object> map = new HashMap<String, Object>();
        temp_key = reference.push().getKey();
        reference.updateChildren(map);

        DatabaseReference child_ref = reference.child(temp_key);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", user_name);
        map2.put("msg", MessageBox.getText().toString());
        child_ref.updateChildren(map2).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        MessageBox.setText("");

    }
    // Allows messages to be shown with user name.
    public void append_chat(DataSnapshot ss) {
        String chat_msg, chat_username;
        Iterator i = ss.getChildren().iterator();
        while (i.hasNext()) {
            chat_msg = ((DataSnapshot) i.next()).getValue().toString();
            chat_username = ((DataSnapshot) i.next()).getValue().toString();
            MessageView.append(chat_username + ": " + chat_msg + " \n");
        }
    }


}