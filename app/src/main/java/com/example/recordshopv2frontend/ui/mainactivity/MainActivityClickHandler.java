package com.example.recordshopv2frontend.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.recordshopv2frontend.ui.addalbum.AddAlbum;

public class MainActivityClickHandler {
    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void addAlbumButtonClicked(View view) {
        Intent intent = new Intent(view.getContext(), AddAlbum.class);
        context.startActivity(intent);
    }
}
