package com.example.recordshopv2frontend.ui.mainactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.recordshopv2frontend.R;
import com.example.recordshopv2frontend.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        ImageView albumArt;
        TextView albumName;
        TextView artistName;
        TextView genre;
        TextView releaseYear;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            albumArt = itemView.findViewById(R.id.albumArt);
            albumName = itemView.findViewById(R.id.albumName);
            artistName = itemView.findViewById(R.id.artistName);
            genre = itemView.findViewById(R.id.genre);
            releaseYear = itemView.findViewById(R.id.releaseYear);
        }
    }
}
