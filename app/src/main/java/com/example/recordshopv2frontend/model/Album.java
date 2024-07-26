package com.example.recordshopv2frontend.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshopv2frontend.BR;

public class Album extends BaseObservable {
    private long id;
    private String albumName;
    private Artist artist;
    private String genre;
    private String artUrl;
    private int releaseYear;
    private int stockQuantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        notifyPropertyChanged(BR.albumName);
    }

    @Bindable
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
        notifyPropertyChanged(BR.artUrl);
    }

    @Bindable
    public String getReleaseYear() {
        return String.valueOf(releaseYear);
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = Integer.valueOf(releaseYear);
        notifyPropertyChanged(BR.releaseYear);
    }

    @Bindable
    public String getStockQuantity() {
        return String.valueOf(stockQuantity);
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = Integer.valueOf(stockQuantity);
        notifyPropertyChanged(BR.stockQuantity);
    }
}


