package com.rdtl.krishi_tottho;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;
/*import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;*/


public class Retrofitm {
   // String baseUrl = "https://pixabay.com/";
   // String baseUrl = "http://192.168.137.1:80";
    String baseUrl = "https://0b8ae664cfd8.ngrok.io/";


    Context context;

    public <T> T getService(Class<T> serviceClass) {
        return getRetrofit().create(serviceClass);
    }

    public synchronized retrofit2.Retrofit getRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        OkHttpClient client = httpClient.build();
        return new retrofit2.Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}