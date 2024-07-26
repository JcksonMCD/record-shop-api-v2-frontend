package com.example.recordshopv2frontend.ui.mainactivity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshopv2frontend.R;
import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.model.AlbumResponse;
import com.example.recordshopv2frontend.service.AlbumService;
import com.example.recordshopv2frontend.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;
    private List<Album> albumList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        albumAdapter = new AlbumAdapter(albumList);
        recyclerView.setAdapter(albumAdapter);

        fetchAlbums();
    }

    private void fetchAlbums() {
        AlbumService service = RetrofitInstance.getClient();
        Call<AlbumResponse> call = service.getAllAlbums(0, 10);

        call.enqueue(new Callback<AlbumResponse>() {
            @Override
            public void onResponse(Call<AlbumResponse> call, Response<AlbumResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    AlbumResponse albumResponse = response.body();
                    albumList.clear(); // Clear existing data
                    albumList.addAll(albumResponse.getContent()); // Add new data
                    albumAdapter.notifyDataSetChanged(); // Notify adapter of data change
                } else {
                    Log.e("MainActivity", "Failed to fetch albums: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<AlbumResponse> call, Throwable t) {
                Log.e("MainActivity", "Error fetching albums", t);
            }
        });
    }
}