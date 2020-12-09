//Used a tutorial to help build my navbar. Adjusting the design for my own project
// Changing Variable names for my use.

package com.example.bikensave;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.bikensave.R.id.fragment_container;

/* Main Class for the FYP Project. After a splashscreen loads, this will be the first screen
   The bikegps co-ordinates will load and fragments will be placed in the nav bar for easy access to
   on their screens. Due to the fragment handler I can Include the maps in a fragment */
public class MainActivityBikeNSave extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    /*Creating a Nav Bar for bikensave*/
    private DrawerLayout drawer;
    /*Setting Toolbar as Action Bar*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        /*Making reference to the Navigation View*/
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /* Passing String values from string value file*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MapsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_maps);


        }
    }

     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_maps:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MapsFragment()).commit();
                //Make sure it is executed and not anything below
                break;

            case R.id.nav_login:
                // New activity to be started.
                Intent intent= new Intent(MainActivityBikeNSave.this,LoginBikeNSave.class);
                startActivity(intent);

                break;
            case R.id.nav_recommendations:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_chat:
                // New activity to be started.
                Intent Screen= new Intent(MainActivityBikeNSave.this,Chatroom2.class);
                startActivity(Screen);
                break;

        }

         drawer.closeDrawer(GravityCompat.START);
         return true;
     }

     /*Coded in so the activity is not left and just to close navigation drawer*/
     @Override
     public void onBackPressed() {
         if (drawer.isDrawerOpen(GravityCompat.START)) {
             drawer.closeDrawer(GravityCompat.START);
         } else {
             super.onBackPressed();
         }
     }



 }