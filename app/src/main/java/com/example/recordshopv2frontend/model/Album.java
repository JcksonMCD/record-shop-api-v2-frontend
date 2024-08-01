package com.example.recordshopv2frontend.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import com.example.recordshopv2frontend.BR;

public class Album extends BaseObservable implements Parcelable {
    private long id;
    private String albumName;
    private Artist artist;
    private String genre;
    private String artUrl;
    private int releaseYear;
    private int stockQuantity;

    public Album(String albumName, Artist artist, String genre, String artUrl, int releaseYear, int stockQuantity) {
        this.albumName = albumName;
        this.artist = artist;
        this.genre = genre;
        this.artUrl = artUrl;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
    }

    public Album() {
    }

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
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }

    @Bindable
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.stockQuantity);
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, int value) {
        if (view.getText() != null
                && ( !view.getText().toString().isEmpty() )
                && Integer.parseInt(view.getText().toString()) != value) {
            view.setText(Integer.toString(value));
        }
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getText(TextView view) {
        return Integer.parseInt(view.getText().toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int i) {
        dest.writeLong(id);
        dest.writeString(artist.getName());
        dest.writeString(genre);
        dest.writeString(albumName);
        dest.writeString(artUrl);
        dest.writeInt(releaseYear);
        dest.writeInt(stockQuantity);
    }
}


