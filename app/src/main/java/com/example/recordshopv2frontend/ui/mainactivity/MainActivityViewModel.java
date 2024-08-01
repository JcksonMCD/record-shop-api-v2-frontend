package com.example.recordshopv2frontend.ui.mainactivity;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.model.AlbumRepository;

public class MainActivityViewModel extends AndroidViewModel {
    private final AlbumRepository albumRepository;

    public MainActivityViewModel(Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public void addAlbum(Album album) {
        albumRepository.addAlbum(album);
    }

    public void editAlbum(long id, Album album) {
        albumRepository.editAlbum(id, album);
    }

    public void deleteAlbum(long id) {
        albumRepository.deleteAlbum(id);
    }

}
