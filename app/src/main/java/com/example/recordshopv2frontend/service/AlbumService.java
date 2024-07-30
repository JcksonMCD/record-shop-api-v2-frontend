package com.example.recordshopv2frontend.service;

import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.model.AlbumResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AlbumService {
    @GET("album")
    Call<AlbumResponse> getAllAlbums(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);

    @POST("album")
    Call<Album> postAlbum(@Body Album album);
}
