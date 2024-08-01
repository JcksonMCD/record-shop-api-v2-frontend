package com.example.recordshopv2frontend.ui.updatealbum;

import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordshopv2frontend.R;
import com.example.recordshopv2frontend.databinding.ActivityUpdateAlbumBinding;
import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbum extends AppCompatActivity {
    ActivityUpdateAlbumBinding activityUpdateAlbumBinding;
    UpdateAlbumClickHandler updateAlbumClickHandler;
    Album album;

    private static final String ALBUM_KEY = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            album = getIntent().getParcelableExtra("ALBUM_KEY", Album.class);
        }

        activityUpdateAlbumBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_update_album
        );

        activityUpdateAlbumBinding.setAlbum(album);

        MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        updateAlbumClickHandler = new UpdateAlbumClickHandler(
                this,
                album,
                model
        );

        activityUpdateAlbumBinding.setClickHandler(updateAlbumClickHandler);
    }
}