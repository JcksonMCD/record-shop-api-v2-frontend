package com.example.recordshopv2frontend.ui.mainactivity;

import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.model.AlbumRepository;

public class MainActivityViewModel {
    AlbumRepository albumRepository;

    public MainActivityViewModel(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public void addAlbum(Album album) {
        albumRepository.addAlbum(album);
    }

}
