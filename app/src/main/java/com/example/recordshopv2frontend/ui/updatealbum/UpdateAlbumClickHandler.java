package com.example.recordshopv2frontend.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.ui.mainactivity.MainActivity;
import com.example.recordshopv2frontend.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandler {
    private Context context;
    private Album album;
    private MainActivityViewModel model;
    private long albumID;

    public UpdateAlbumClickHandler(Context context, Album album, MainActivityViewModel model) {
        this.context = context;
        this.album = album;
        this.model = model;
    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
