package com.example.bikensave;
// Using Google maps API see Read ME file in APP
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {


    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        //Creating the map.

        @Override
        public void onMapReady(GoogleMap googleMap) {
            
            //Adding zoom feauture in so map loads in cork
            LatLng Cork = new LatLng(51.898946, -8.476309);
            googleMap.addMarker(new MarkerOptions().position(Cork).title("User Location In Cork City"));

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Cork, 14));


            LatLng CastleStreet= new LatLng(51.898782, -8.476496);
            googleMap.addMarker(new MarkerOptions().position(CastleStreet).title("Station in Castle Street"));

            LatLng Dealz= new LatLng(51.898647, -8.475735);
            googleMap.addMarker(new MarkerOptions().position(Dealz).title("Station by Dealz"));

            LatLng Capitol= new LatLng(51.898055, -8.475164);
            googleMap.addMarker(new MarkerOptions()
                    .position(Capitol)
                    .title("Station near the Capitol complex")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

            LatLng GPR= new LatLng(51.896050, -8.474160);
            googleMap.addMarker(new MarkerOptions().position(GPR).title("Station on Grand Parade"));

            LatLng GPR2= new LatLng(51.896251, -8.473909);
            googleMap.addMarker(new MarkerOptions().position(GPR2).title("Marker near Grand Parade"));


            //Icons for all the rental areas for Coke Zero Bikes
            LatLng CokeZero1= new LatLng(51.89980089030018, -8.47854021934494);
            googleMap.addMarker(new MarkerOptions()
                    .position(CokeZero1)
                    .title("Coke Zero Rental UCC")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));




        }

    };



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

}