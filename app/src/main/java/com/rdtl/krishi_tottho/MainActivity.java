package com.rdtl.krishi_tottho;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;


    Retrofitm retrofitm;
    PixabayAdapter adapter;
    int currentPage = 0;
    HashMap<String, String> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        retrofitm = new Retrofitm();





        init();
       // loadNextPage();
    }



    public void init() {
        map.put("key", "18221034-1b35547c30d429e60a1dfe771");
        map.put("q", "animal");
        map.put("image_type", "all");
        map.put("page", "1");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://0b8ae664cfd8.ngrok.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        PixabayService jsonPlaceHolderApi = retrofit.create(PixabayService.class);

       // Call<List<Hit>> call = jsonPlaceHolderApi.getImages();

        Call<List<Hit>> call = jsonPlaceHolderApi.getImagess("https://a42396d85d01.ngrok.io/api/v1/fishes=1");


        call.enqueue(new Callback<List<Hit>>() {
            @Override
            public void onResponse(Call<List<Hit>> call, Response<List<Hit>> response) {
                if (!response.isSuccessful()) {
                   // textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Hit> hits = response.body();


                adapter = new PixabayAdapter(MainActivity.this, hits);
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                currentPage = 1;

            }
            @Override
            public void onFailure(Call<List<Hit>> call, Throwable t) {
               // textViewResult.setText(t.getMessage());
            }
        });
    }


}

   /* public void loadNextPage() {
        map.put("page", (currentPage + 1) + "");
        Call<PixabayResponse> call = retrofit.getService(PixabayService.class).getImages();
        call.enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                PixabayResponse pixabayResponse = response.body();
                List<Hit> hits = pixabayResponse.getHits();
                adapter = new PixabayAdapter(getApplicationContext(), hits);
                adapter.addItems(hits);
                currentPage++;
            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/


