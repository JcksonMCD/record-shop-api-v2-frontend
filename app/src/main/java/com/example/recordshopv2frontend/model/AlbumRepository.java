package com.example.recordshopv2frontend.model;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.recordshopv2frontend.service.AlbumService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.recordshopv2frontend.service.RetrofitInstance;

public class AlbumRepository {
    private final Context context;

    public AlbumRepository(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addAlbum(Album album) {
        AlbumService albumService = RetrofitInstance.getClient();
        Call<Album> call = albumService.postAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(context, "Album added to database", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(context, "Album unable to be added to database", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void editAlbum(long id, Album album){
        AlbumService albumService = RetrofitInstance.getClient();
        Call<Album> call = albumService.putAlbum(id, album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(context, "Album edited successfully", Toast.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(context, "Album unable to be edited", Toast.LENGTH_SHORT);
            }
        });
    }

    public void deleteAlbum(long id){
        AlbumService albumService = RetrofitInstance.getClient();
        Call<String> call = albumService.deleteAlbum(id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(context, "Album deleted successfully", Toast.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Toast.makeText(context, "Album unable to be deleted", Toast.LENGTH_SHORT);
            }
        });
    }
}
