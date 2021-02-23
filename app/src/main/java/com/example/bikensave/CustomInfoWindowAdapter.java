package com.example.bikensave;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;
//Similar to the Recycler View I need to create an adapter
// to populate the layout in the marker windows
// https://www.youtube.com/watch?v=DhYofrJPzlI

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private MapsFragment context;

    public CustomInfoWindowAdapter(MapsFragment context){
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = context.getLayoutInflater().inflate(R.layout.custom_info_window, null);

        TextView locTitle = (TextView) view.findViewById(R.id.titleMarker);
        TextView locDesc = (TextView) view.findViewById(R.id.MarkerDesc);

        locTitle.setText(marker.getTitle());
        locDesc.setText(marker.getSnippet());

        return view;
    }
}