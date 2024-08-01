package com.example.recordshopv2frontend.ui.updatealbum;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshopv2frontend.model.Album;
import com.example.recordshopv2frontend.ui.mainactivity.MainActivity;
import com.example.recordshopv2frontend.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;

public class UpdateAlbumClickHandler {
    private Context context;
    private Album album;
    private MainActivityViewModel model;
    private long albumID;

    public UpdateAlbumClickHandler(Context context, Album album, MainActivityViewModel model) {
        this.context = context;
        this.album = album;
        this.model = model;
    }

    public void backButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void deleteButtonClicked(View view) {

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
        alertBuilder.setTitle("Delete this album?")
                .setMessage("This will delete " + album.getAlbumName() + " by " + album.getArtist().getName() + " permanently.")
                .setPositiveButton("Delete", (dialog, id) -> {
                    Intent intent = new Intent(context, MainActivity.class);
                    albumID = album.getId();
                    model.deleteAlbum(albumID);
                    context.startActivity(intent);
                })
                .setNegativeButton("Cancel", (dialog, which) -> { });
        alertBuilder.show();
    }

    public void submitButtonClicked(View view) {

        Album updatedAlbum = new Album(
                album.getAlbumName(),
                album.getArtist(),
                album.getGenre(),
                album.getArtUrl(),
                album.getReleaseYear(),
                album.getStockQuantity()
        );

        if (Objects.equals(updatedAlbum.getArtist(), "") ||
                Objects.equals(updatedAlbum.getGenre(), "") ||
                Objects.equals(updatedAlbum.getAlbumName(), "") ||
                Objects.equals(updatedAlbum.getArtUrl(), "") ||
                Objects.equals(updatedAlbum.getReleaseYear(), "") ||
                Objects.equals(updatedAlbum.getStockQuantity(), "")) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);
            albumID = album.getId();
            model.editAlbum(albumID, updatedAlbum);
            context.startActivity(intent);
        }
    }
}
