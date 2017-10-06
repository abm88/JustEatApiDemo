package com.example.abdulbasith.justeatapidemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.abdulbasith.justeatapidemo.AppServices.ConnectionService;
import com.example.abdulbasith.justeatapidemo.AppServices.IRequestInterface;
import com.example.abdulbasith.justeatapidemo.maps.ResturantsMakers;
import com.example.abdulbasith.justeatapidemo.model.Restaurant;
import com.example.abdulbasith.justeatapidemo.model.ResturentListModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private IRequestInterface iRequestInterface;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Intent intent = new Intent(this, ResturantsMakers.class);

        inializeRecycler();
        iRequestInterface = ConnectionService.getConnectionService();
        iRequestInterface.getRestaurantList(API_Constants.VALUE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::Success, this::onError);

    }

    private void Success(ResturentListModel resturentListModels) {
        //Log.i("Restaurant ",resturentListModels.);
        recyclerView.setAdapter(new AppAdapter(resturentListModels.getRestaurants(), R.layout.row, getApplicationContext()));
    }


    private void onError(Throwable throwable) {
    Log.i("This error --> ", throwable.getMessage());
    }


    private void inializeRecycler() {
      recyclerView = (RecyclerView)findViewById(R.id.rvListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }
}
