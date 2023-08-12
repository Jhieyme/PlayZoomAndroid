package com.jennifer.playzoom.data.retrofit;

import com.jennifer.playzoom.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MoviesInterface {
   @GET("975c7c92-d410-4199-a0ae-ff1790e2b9cf")
   Call<ShowResponse> getShows();
}
