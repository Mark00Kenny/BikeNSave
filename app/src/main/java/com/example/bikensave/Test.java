//Using the Android Studio Template for a Navigation Pane. Adjusting the design for my own project
// Changing Variable names for my use.
/*
package com.example.bikensave;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
/* Main Class for the FYP Project. After a splashscreen loads, this will be the first screen
   The bikegps co-ordinates will load and fragments will be placed in the nav bar for easy access to
   on their screens.
public class MainActivityBikeNSave extends AppCompatActivity implements OnMapReadyCallback {

    /*Creating a Nav Bar for bikensave
    private AppBarConfiguration MainNavigationWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.nav_home);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override

            //Ensuring that when you click on NavBar Side fragments and Activities load.
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        MainNavigationWindow = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_controller_view_tag);
        NavigationUI.setupActionBarWithNavController(this, navController, MainNavigationWindow);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_controller_view_tag);
        return NavigationUI.navigateUp(navController, MainNavigationWindow)
                || super.onSupportNavigateUp();
    }

    private GoogleMap mMap;


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Patrick's Street.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.

    @Override
    // Allows the Google Maps Enabled API Key to load enabling maps development.
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Ireland = new LatLng(51.898946, -8.476309);
        mMap.addMarker(new MarkerOptions().position(Ireland).title("Marker in Cork"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Ireland));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
*/