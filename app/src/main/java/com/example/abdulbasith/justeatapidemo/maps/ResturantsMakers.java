package com.example.abdulbasith.justeatapidemo.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.abdulbasith.justeatapidemo.API_Constants;
import com.example.abdulbasith.justeatapidemo.AppServices.ConnectionService;
import com.example.abdulbasith.justeatapidemo.AppServices.IRequestInterface;
import com.example.abdulbasith.justeatapidemo.PicassoMarker;
import com.example.abdulbasith.justeatapidemo.R;
import com.example.abdulbasith.justeatapidemo.model.Restaurant;
import com.example.abdulbasith.justeatapidemo.model.ResturentListModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URL;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.abdulbasith.justeatapidemo.R.id.map;

public class ResturantsMakers extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<Restaurant> restaurant;
    private IRequestInterface iRequestInterface;
    private PicassoMarker picassoMarker;


    //private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturants_makers);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        iRequestInterface = ConnectionService.getConnectionService();
        iRequestInterface.getRestaurantList(API_Constants.VALUE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::Success, this::onError);

       // LatLng restuarantLng = new LatLng(restaurant.getLongitude(),restaurant.getLatitude())

        // Add a marker in Sydney and move the camera

    }

    private void onError(Throwable throwable) {
        Log.i("This error --> ", throwable.getMessage());
    }

    private void Success(ResturentListModel resturentListModel) {
        Marker markers = null, myMarker;
    //  BitmapDescriptor bitmap = BitmapDescriptorFactory.fromBitmap(Bitmap.createBitmap(resturentListModel.getRestaurants()))
        for (int i = 0; i < resturentListModel.getRestaurants().size(); i++) {

            LatLng myRetaurantsMarker = new LatLng(resturentListModel.getRestaurants().get(i).getLatitude(), resturentListModel.getRestaurants().get(i).getLongitude());
//           mMap.addMarker(new MarkerOptions().position(myRetaurantsMarker).title(resturentListModel.getRestaurants().get(i).getName())
//          .snippet(resturentListModel.getRestaurants().get(i).getRatingAverage().toString())
//           //.icon(resturentListModel.getRestaurants().get(i).getLogo())
//
//            );

            myMarker = mMap.addMarker(new MarkerOptions().position(myRetaurantsMarker));

            //markers = new picassoMarker(myMarker);
            PicassoMarker myPM = new PicassoMarker(myMarker);
           // markers.setIcon(BitmapDescriptorFactory.fromBitmap());

            Picasso.with(getApplicationContext())
                    .load(resturentListModel.getRestaurants().get(0).getLogo().get(i).getStandardResolutionURL())
                    .resize(100,100)
                    .into(new PicassoMarker(mMap.addMarker(new MarkerOptions()
                    .position(myRetaurantsMarker).title(resturentListModel.getRestaurants().get(i).getName())
                            .snippet(resturentListModel.getRestaurants().get(i).getRatingAverage().toString())
                    )));
//            Picasso.with(new ResturantsMakers()).load((Uri) resturentListModel.getRestaurants().get(i).getLogo()).into();
            //mMap.addMarker(new MarkerOptions().position(myRetaurantsMarker).title(restaurant.get(i).getBadges()));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myRetaurantsMarker,11));

        }
    }
}
