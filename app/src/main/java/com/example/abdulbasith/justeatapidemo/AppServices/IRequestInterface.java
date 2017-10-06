package com.example.abdulbasith.justeatapidemo.AppServices;

import android.provider.SyncStateContract;

import com.example.abdulbasith.justeatapidemo.API_Constants;
import com.example.abdulbasith.justeatapidemo.model.ResturentListModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by AbdulBasit on 04/10/2017.
 */

public interface IRequestInterface {

    @Headers({
            API_Constants.HEADER_ACCEPT_TENANT,
            API_Constants.HEADER_ACCEPT_LANGUAGE,
            API_Constants.HEADER_AUTHORIZATION,
            API_Constants.HEADER_HOST})

    @GET(API_Constants.BASE_URL)
    Observable <ResturentListModel> getRestaurantList(@Query(API_Constants.QUERY) String location);
}


