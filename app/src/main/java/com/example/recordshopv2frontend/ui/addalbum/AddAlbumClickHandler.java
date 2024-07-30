package com.example.recordshopv2frontend.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshopv2frontend.model.Album;
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
        if (album.getArtist() == null ||
                album.getAlbumName() == null ||
                album.getGenre() == null ||
                album.getReleaseYear() == null ||
                album.getStockQuantity() == null) {
            Toast.makeText(context, "Fields must not be empty", Toast.LENGTH_SHORT).show();
        } else {

        }
    }
}
