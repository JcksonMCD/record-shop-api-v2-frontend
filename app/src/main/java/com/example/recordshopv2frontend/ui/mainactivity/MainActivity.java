package com.example.recordshopv2frontend.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recordshopv2frontend.R;
import com.example.recordshopv2frontend.databinding.ActivityMainBinding;
import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.model.AlbumResponse;
import com.example.recordshopv2frontend.service.AlbumService;
import com.example.recordshopv2frontend.service.RetrofitInstance;
import com.example.recordshopv2frontend.ui.updatealbum.UpdateAlbum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface, AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerView;
    private AlbumAdapter albumAdapter;
    private List<Album> albumList = new ArrayList<>();
    private ActivityMainBinding binding;
    private SearchView searchView;
    private Spinner spinner;
    private String spinnerSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClickHandler(new MainActivityClickHandler(this));

        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        albumAdapter = new AlbumAdapter(albumList, this);
        recyclerView.setAdapter(albumAdapter);

        spinner = binding.dropdown;
        spinner.setOnItemSelectedListener(this);
        String[] dropItems = getResources().getStringArray(R.array.);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dropItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        searchView = binding.searchBar;
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        fetchAlbums();
    }

    private void fetchAlbums() {
        AlbumService service = RetrofitInstance.getClient();
        Call<AlbumResponse> call = service.getAllAlbums(0, 10);

        call.enqueue(new Callback<AlbumResponse>() {
            @Override
            public void onResponse(Call<AlbumResponse> call, Response<AlbumResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    albumList.clear();
                    albumList.addAll(response.body().getContent());
                    albumAdapter.notifyDataSetChanged();
                } else {
                    Log.e("MainActivity", "Failed to fetch albums: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<AlbumResponse> call, Throwable t) {
                Log.e("MainActivity", "Error fetching albums", t);
                Toast.makeText(MainActivity.this, "Error fetching albums", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, UpdateAlbum.class);
        intent.putExtra("ALBUM_KEY", albumList.get(position));
        startActivity(intent);
    }

}
