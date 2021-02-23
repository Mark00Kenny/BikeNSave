package com.example.bikensave;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Chatroom2 extends AppCompatActivity {
    //Referencing the Database
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    // Variables
    EditText TypeRoom;
    ListView ChatRoomList;
    ArrayList<String> ChatArray;
    ArrayAdapter<String> adapter;
    EditText TempName;
    String Name;
    private Object AdapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom2);

        // Setting my variables.
        // TypeRoom = (EditText) findViewById(R.id.editText);
        ChatRoomList = (ListView) findViewById(R.id.listView);
        ChatArray = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ChatArray);
        ChatRoomList.setAdapter(adapter);
        request_name();

        // Setting refrence of chatroom to avoid showing users.
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("chatrooms");


        //Allows for a new room to be entered into database.
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datSnapshot) {
                Set<String> myRooms = new HashSet<>();
                Iterator iterator = datSnapshot.getChildren().iterator();
                while (iterator.hasNext()) {
                    myRooms.add(((DataSnapshot) iterator.next()).getKey());
                }
                ChatArray.clear();
                ChatArray.addAll(myRooms);
                adapter.notifyDataSetChanged();
            }
            //Error handling in case any errors with the database occur.
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Sorry network issue has occured", Toast.LENGTH_LONG).show();

            }
        });
            // When particular forum is clicked allows for user to be taken to which ever one
            //they selected.
        ChatRoomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(Chatroom2.this, Chatroom.class);
                intent.putExtra("room_name", ((TextView) view).getText().toString());
                intent.putExtra("user_name", Name);
                startActivity(intent);

            }
        });

    }
        //Allows for a temporary username to be generated so users can interact with the application
    public void request_name() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Please Enter a Chatroom Name");
        TempName = new EditText(this);
        alertDialog.setView(TempName);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Name = TempName.getText().toString();
            }
        });
        // If a name isn't selected they cannot move forward to the chat.
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
                request_name();
            }
        });
        alertDialog.show();
    }

    // This line is commented out. Allows for creation of more chat rooms but
    // I do not want users to have this capability only if I want to add more.
    /*
    public void create_chatroom(View v) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(TypeRoom.getText().toString(), "Chatroom");
        reference.updateChildren(hashMap);

        ChatArray.add(TypeRoom.getText().toString());
        adapter.notifyDataSetChanged();
    }
    */

}
