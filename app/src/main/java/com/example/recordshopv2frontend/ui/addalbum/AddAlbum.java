package com.example.recordshopv2frontend.ui.addalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordshopv2frontend.R;
import com.example.recordshopv2frontend.databinding.ActivityAddAlbumBinding;
import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.ui.mainactivity.MainActivityViewModel;

public class AddAlbum extends AppCompatActivity {
    ActivityAddAlbumBinding binding;
    MainActivityViewModel model;
    AddAlbumClickHandler clickHandler;
    Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);

        album = new Album();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_album);
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        clickHandler = new AddAlbumClickHandler(album, this, model);
        binding.setClickHandler(clickHandler);
        binding.setAlbum(album);

    }
}