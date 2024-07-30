package com.example.recordshopv2frontend.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.model.Artist;
import com.example.recordshopv2frontend.ui.mainactivity.MainActivity;
import com.example.recordshopv2frontend.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandler {
    Album album;
    Context context;
    MainActivityViewModel mainActivityViewModel;

    public AddAlbumClickHandler(Album album, Context context, MainActivityViewModel mainActivityViewModel) {
        this.album = album;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void submitButtonClicked(View view) {
        // Seperated out toasts to help debug
        Artist artist = album.getArtist();
        if (artist == null || artist.getName() == null || artist.getName().isEmpty()) {
            Toast.makeText(context, "Artist field must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (album.getAlbumName() == null || album.getAlbumName().isEmpty()) {
            Toast.makeText(context, "Album name must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (album.getGenre() == null || album.getGenre().isEmpty()) {
            Toast.makeText(context, "Genre must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (album.getReleaseYear() == 0) {
            Toast.makeText(context, "Release year must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (album.getStockQuantity() == 0) {
            Toast.makeText(context, "Stock quantity must not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        // Proceed with submission
        Album submitAlbum = new Album(
                album.getAlbumName(),
                new Artist(artist.getName()),
                album.getGenre(),
                album.getArtUrl(),
                album.getReleaseYear(),
                album.getStockQuantity()
        );

        mainActivityViewModel.addAlbum(submitAlbum);
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        }
}
