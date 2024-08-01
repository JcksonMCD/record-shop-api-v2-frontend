package com.example.recordshopv2frontend.ui.updatealbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.recordshopv2frontend.R;
import com.example.recordshopv2frontend.databinding.ActivityUpdateAlbumBinding;
import com.example.recordshopv2frontend.model.Album;

public class UpdateAlbum extends AppCompatActivity {
    ActivityUpdateAlbumBinding activityUpdateAlbumBinding;
    UpdateAlbumClickHandler updateAlbumClickHandler;
    Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_album);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}