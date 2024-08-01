package com.example.recordshopv2frontend.ui.updatealbum;

import android.content.Context;

import com.example.recordshopv2frontend.model.Album;
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
}
