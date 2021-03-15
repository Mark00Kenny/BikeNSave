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
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {


    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        //Creating the map.

        @Override
        public void onMapReady(GoogleMap googleMap) {
            //Adding zoom feauture in so map loads in cork also adding this marker as the legend for the map
            LatLng Cork = new LatLng(51.898946, -8.472309);
            googleMap.addMarker(new MarkerOptions().position(Cork)
                    .title("Cork City Center Legend")
                    .snippet("Bike Station = \uD83D\uDD34 \uD83D\uDD12\uD83D\uDEB2 \n \n Bike Rental = \uD83D\uDD35 \uD83D\uDCB0\uD83D\uDEB2 \n \n Bike Shop = \uD83D\uDED2 \uD83D\uDEB2 \uD83D\uDD27\uD83D\uDCB0 \n \n Garda Station = \uD83D\uDC6E \uD83D\uDD75 \uD83D\uDEB2 \n \n CCTV: Present = \uD83D\uDCF7 \n \n CCTV: Missing = \uD83D\uDEAB \n \n")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.questionmark)));

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Cork, 14));

            //Locations for all of the locking stations.
            LatLng CastleStreet = new LatLng(51.898782, -8.476496);
            googleMap.addMarker(new MarkerOptions()
                    .position(CastleStreet)
                    .title("Station in Castle Street \uD83D\uDEB2 \uD83D\uDD12")
                    .snippet("Security Rating ⭐⭐ (1)\n \n CCTV: \uD83D\uDCF7"))
            ;


            LatLng Dealz = new LatLng(51.898647, -8.475735);
            googleMap.addMarker(new MarkerOptions()
                    .position(Dealz)
                    .title("Station by Dealz \uD83D\uDEB2 \uD83D\uDD12")
                    .snippet("Security Rating ⭐⭐⭐ (11)\n \n CCTV: \uD83D\uDEAB"));

            LatLng Capitol = new LatLng(51.898055, -8.475164);
            googleMap.addMarker(new MarkerOptions()
                    .position(Capitol)
                    .title("Station near the Capitol complex \uD83D\uDEB2 \uD83D\uDD12")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    .snippet("Security Rating ⭐⭐⭐⭐ (3)\n \n CCTV: \uD83D\uDCF7"));

            LatLng GPR = new LatLng(51.896050, -8.474160);
            googleMap.addMarker(new MarkerOptions()
                    .position(GPR)
                    .title("Station on Grand Parade \uD83D\uDEB2 \uD83D\uDD12")
                    .snippet("Security Rating ⭐⭐⭐⭐ (6)\n \n CCTV: \uD83D\uDCF7"))
                    ;

            LatLng GPR2 = new LatLng(51.896251, -8.473909);
            googleMap.addMarker(new MarkerOptions()
                    .position(GPR2)
                    .title("Marker near Grand Parade \uD83D\uDEB2 \uD83D\uDD12")
                    .snippet("Security Rating ⭐⭐⭐⭐ (2)\n \n CCTV: \uD83D\uDEAB"));


            //Icons for all the rental areas for Coke Zero Bikes
            LatLng CokeZero1 = new LatLng(51.896181810053456, -8.468107101545982);
            googleMap.addMarker(new MarkerOptions()
                    .position(CokeZero1)
                    .title("Coke Zero Rental \n \nCork School of Music\uD83D\uDCB0 \uD83D\uDEB2")
                    .snippet("Security Rating ⭐⭐⭐⭐ (3)\n \n CCTV:\uD83D\uDCF7")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            //Icons for all the rental areas for Coke Zero Bikes
            LatLng CokeZero2 = new LatLng(51.89980089030018, -8.47854021934494);
            googleMap.addMarker(new MarkerOptions()
                    .position(CokeZero2)
                    .title("Coke Zero Rental UCC \uD83D\uDCB0 \uD83D\uDEB2 \n \n")
                    .snippet("Security Rating ⭐⭐⭐⭐⭐ (1)\n \n CCTV:\uD83D\uDCF7")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            //Icons for all the Bike Shops
            LatLng BikeShed = new LatLng(51.889363814524536, -8.505366065240123);
            googleMap.addMarker(new MarkerOptions()
                    .position(BikeShed)
                    .title("The Bike Shed \uD83D\uDED2 \uD83D\uDEB2 \uD83D\uDD27")
                    .snippet("Opening Hours Monday-Friday 9am-5pm \n \n Description:Sale of Bike Related goods, Repairs and sale of bikes")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.bikeshed)));

            LatLng VictoriaCross = new LatLng(51.892261390308754, -8.506171183848389);
            googleMap.addMarker(new MarkerOptions()
                    .position(VictoriaCross)
                    .title("Victoria Cross Cycles \uD83D\uDED2 \uD83D\uDEB2 \uD83D\uDD27")
                    .snippet("Opening Hours Monday-Friday 9am-5pm \n \n Description:Sale of Bike Related goods, Repairs and sale of bikes")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.victoriacrosscycles)));

            LatLng EdgeCork = new LatLng(51.89838188128874, -8.467447101639129);
            googleMap.addMarker(new MarkerOptions()
                    .position(EdgeCork)
                    .title("The Edge \uD83D\uDED2 \uD83D\uDEB2 \uD83D\uDD27")
                    .snippet("Opening Hours Monday-Friday 9am-5pm \n \n Description:Sale of Athletic Bikes, Bike Gear and athletic assortment")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.theedge)));

            //Icons for all the Garda Stations
            LatLng Anglesea = new LatLng(51.89581881090926, -8.465243045729116);
            googleMap.addMarker(new MarkerOptions()
                    .position(Anglesea)
                    .title("Anglesea Street Station \uD83D\uDC6E \uD83D\uDD75 \uD83D\uDEB2")
                    .snippet("Contact Number: 0214522000 \n \n Description: Garda Station")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gardasymbol)));

            LatLng gurran = new LatLng(51.903557473097656, -8.496556888055572);
            googleMap.addMarker(new MarkerOptions()
                    .position(gurran)
                    .title("Gurranabraher Station \uD83D\uDC6E \uD83D\uDD75 \uD83D\uDEB2")
                    .snippet("Contact Number: 0214946200 \n \n Description: Garda Station")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gardasymbol)));

            LatLng btown = new LatLng(51.880821129636146, -8.514615301546575);
            googleMap.addMarker(new MarkerOptions()
                    .position(btown)
                    .title("Bishopstown Station \uD83D\uDC6E \uD83D\uDD75 \uD83D\uDEB2")
                    .snippet("Contact Number: 0214624500 \n \n Description: Garda Station")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gardasymbol)));

            LatLng togher = new LatLng(51.87654479186797, -8.486313988089151);
            googleMap.addMarker(new MarkerOptions()
                    .position(togher)
                    .title("Togher Station \uD83D\uDC6E \uD83D\uDD75 \uD83D\uDEB2")
                    .snippet("Contact Number: 0214947120 \n \n Description: Garda Station")
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.gardasymbol)));



            //Set Custom InfoWindow Adapter
            CustomInfoWindowAdapter adapter = new CustomInfoWindowAdapter(MapsFragment.this);
            googleMap.setInfoWindowAdapter(adapter);

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