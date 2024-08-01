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

    private List<Album> albumList;
    RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(List<Album> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.albumName.setText(album.getAlbumName());
        holder.artistName.setText(album.getArtist().getName());
        holder.genre.setText(album.getGenre());
        holder.releaseYear.setText(String.valueOf(album.getReleaseYear()));

        // Load image using Glide
        Glide.with(holder.itemView.getContext())
                .load(album.getArtUrl())
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.placeholder_image)
                .into(holder.albumArt);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

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
