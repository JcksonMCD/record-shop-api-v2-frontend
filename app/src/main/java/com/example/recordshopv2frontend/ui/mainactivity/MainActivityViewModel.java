package com.example.recordshopv2frontend.ui.mainactivity;

import androidx.lifecycle.ViewModel;

import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.model.AlbumRepository;

public class MainActivityViewModel extends ViewModel {
    AlbumRepository albumRepository = new AlbumRepository();

    public MainActivityViewModel() {

    }

    public void addAlbum(Album album) {
        albumRepository.addAlbum(album);
    }

}
