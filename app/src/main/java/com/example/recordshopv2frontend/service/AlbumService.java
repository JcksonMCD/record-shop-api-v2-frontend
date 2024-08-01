package com.example.recordshopv2frontend.service;

import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.model.AlbumResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AlbumService {
    @GET("album")
    Call<AlbumResponse> getAllAlbums(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);

    @POST("album")
    Call<Album> postAlbum(@Body Album album);

    @PUT("album/{id}")
    Call<Album> putAlbum(@Path("id") long id, @Body Album album);


}
