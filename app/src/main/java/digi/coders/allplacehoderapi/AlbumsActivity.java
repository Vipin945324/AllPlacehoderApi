package digi.coders.allplacehoderapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AlbumsActivity extends AppCompatActivity {

    RecyclerView albumsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        albumsRecycler=findViewById(R.id.albumsRecycler);
    }
}