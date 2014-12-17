package com.doctinator.doctinator;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindPlaceMapsActivity extends FragmentActivity {



    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_place_maps);

        try {
            setUpMapIfNeeded();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            setUpMapIfNeeded();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() throws IOException {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() throws IOException {

        // Enable geolocalisation
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // A class indicating the application criteria for selecting a location provider. Providers maybe ordered according to accuracy, power usage, ability to report altitude, speed, and bearing, and monetary cost.
        Criteria criteria = new Criteria();
        // Get the name of the provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Finally get the last location known
        Location myLocation = locationManager.getLastKnownLocation(provider);

        // Set map attributes
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // latitude + longitude of the myLocation variable
        double latitude = myLocation.getLatitude();
        double longitude = myLocation.getLongitude();
        // Create latLng from the latitude + longitude
        LatLng latLng = new LatLng(latitude, longitude);

        // Show the Map with current location !!!
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        // Set default Zoom of the map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
        // Put the marker
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Vous êtes ici !"));

        // Put another marker
        // mMap.addMarker(new MarkerOptions().position(new LatLng(latitude+0.01, longitude+0.01)).title("Defibrillateur le plus proche"));

        // Parse CSV file to add marker for each position
        List<LatLng> latLngList = new ArrayList<LatLng>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("defibrillateur.csv")));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                double lat = Double.parseDouble(line.split("#")[1]);
                double lon = Double.parseDouble(line.split("#")[2]);
                latLngList.add(new LatLng(lat, lon));
            }

        }
        catch (IOException ex) {
            // handle exception
        }

        // Add markers to the map
        // Add them to map
        //for(LatLng pos : latLngList){
            // System.out.println(pos);
          //  mMap.addMarker(new MarkerOptions().position(new LatLng()).title("Défibrillateur"));
        //}
        System.out.println(new LatLng(latitude, longitude));
        System.out.println(latLngList.get(1));
        for (int i = 0; i < latLngList.size(); i++){
            //System.out.println(latLngList.get(i));
            mMap.addMarker(new MarkerOptions().position(latLngList.get(i)).title("def"));
        }

    }
}
