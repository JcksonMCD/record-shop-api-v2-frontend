package com.example.recordshopv2frontend.model;

public class Album {
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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
    }

    public String getReleaseYear() {
        return String.valueOf(releaseYear);
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = Integer.valueOf(releaseYear);
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

}
