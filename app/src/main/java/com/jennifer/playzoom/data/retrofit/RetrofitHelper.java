package com.jennifer.playzoom.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {
    public static Retrofit instance;
    public static MoviesInterface service;

    // https://run.mocky.io/v3/975c7c92-d410-4199-a0ae-ff1790e2b9cf
    public  static Retrofit getInstance(){
        if (instance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getLoggingBuilder().build())
                    .build();
            instance = retrofit;
        }
        return instance;
    }

    public static OkHttpClient.Builder getLoggingBuilder(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder;
    }

    public static MoviesInterface getService(){
        if (service == null){
            service = getInstance().create(MoviesInterface.class);
        }
        return service;
    }
}
