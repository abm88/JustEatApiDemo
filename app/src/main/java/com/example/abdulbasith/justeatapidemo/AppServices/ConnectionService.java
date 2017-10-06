package com.example.abdulbasith.justeatapidemo.AppServices;

import com.example.abdulbasith.justeatapidemo.API_Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AbdulBasit on 04/10/2017.
 */

public class ConnectionService {

    static Retrofit retrofit;

    public static IRequestInterface getConnectionService(){


        retrofit = new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(IRequestInterface.class);


    }
}
