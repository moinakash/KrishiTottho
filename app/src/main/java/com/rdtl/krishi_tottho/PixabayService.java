package com.rdtl.krishi_tottho;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface PixabayService {

//    @GET("api/v1/vegetables/1/")
    @GET("api/v1/vegetables/{id}/")


   // Call<PixabayResponse> getImages(@QueryMap Map<String, String> parameter);


  //  Call<List<Hit>> getImages();
    Call<List<Hit>> getImages(@Path("id") int postId);


    @GET
    Call<List<Hit>> getImagess(@Url String url);


}


