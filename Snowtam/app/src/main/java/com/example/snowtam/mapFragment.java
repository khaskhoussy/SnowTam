package com.example.snowtam;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class mapFragment extends Fragment {

    private double latitude;
    private double longitude;
    private MapView map;
    View mapFragmentView;


    public mapFragment(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public mapFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Configuration.getInstance().load(getActivity()
                , PreferenceManager.getDefaultSharedPreferences(getActivity()));

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Map");
        mapFragmentView = inflater.inflate(R.layout.fragment_map, container, false);
        map = mapFragmentView.findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);//render
        map.setBuiltInZoomControls(true);//zoomable
        GeoPoint startPoint = new GeoPoint(this.latitude, this.longitude);
        IMapController mapController = map.getController();
        mapController.setZoom(15.0);
        mapController.setCenter(startPoint);
        ArrayList<OverlayItem> items = new ArrayList<>();
        OverlayItem home = new OverlayItem("you'r", "aeroport "
                , new GeoPoint(this.latitude, this.longitude));
        Drawable m = home.getMarker(0);
        items.add(home);

        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(getActivity()
                , items, new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }

            @Override
            public boolean onItemLongPress(int index, OverlayItem item) {
                return false;
            }
        });

        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);

        return mapFragmentView;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
