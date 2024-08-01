package com.example.recordshopv2frontend.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import android.widget.EditText;
import com.example.recordshopv2frontend.BR;

public class Album extends BaseObservable implements Parcelable {
    private long id;
    private String albumName;
    private Artist artist;
    private String genre;
    private String artUrl;
    private int releaseYear;
    private int stockQuantity;

    // Constructor
    public Album(String albumName, Artist artist, String genre, String artUrl, int releaseYear, int stockQuantity) {
        this.albumName = albumName;
        this.artist = artist;
        this.genre = genre;
        this.artUrl = artUrl;
        this.releaseYear = releaseYear;
        this.stockQuantity = stockQuantity;
    }

    // Default constructor
    public Album() {
    }

    // Parcelable constructor
    protected Album(Parcel in) {
        id = in.readLong();
        albumName = in.readString();
        artist = in.readParcelable(Artist.class.getClassLoader());
        genre = in.readString();
        artUrl = in.readString();
        releaseYear = in.readInt();
        stockQuantity = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(albumName);
        dest.writeParcelable(artist, flags);
        dest.writeString(genre);
        dest.writeString(artUrl);
        dest.writeInt(releaseYear);
        dest.writeInt(stockQuantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    // Getters and Setters
    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
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

    // Data Binding Adapters
    @BindingAdapter("android:text")
    public static void setInteger(EditText view, int value) {
        view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static int getInteger(EditText view) {
        String value = view.getText().toString();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0; // default value
        }
    }
}




