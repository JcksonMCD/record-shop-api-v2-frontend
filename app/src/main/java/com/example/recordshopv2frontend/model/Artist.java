package com.example.recordshopv2frontend.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshopv2frontend.BR;

public class Artist extends BaseObservable {
    private long id;
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public Artist() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
