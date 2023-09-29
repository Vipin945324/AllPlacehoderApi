package digi.coders.allplacehoderapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder> {
    Context context;
    List<AlbumsModel>albumsModelList;


    public AlbumsAdapter(Context context, List<AlbumsModel> albumsModelList) {
        this.context = context;
        this.albumsModelList = albumsModelList;
    }

    @NonNull
    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlbumsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsViewHolder holder, int position) {
        AlbumsModel albumsModel=albumsModelList.get(position);
        holder.userid.setText(albumsModel.getUserId());
        holder.id.setText(albumsModel.getId());
        holder.title.setText(albumsModel.getTitle());

        holder.cardAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,AlbumsActivity.class);

            }
        });
    }

    @Override
    public int getItemCount() {
        return albumsModelList.size();
    }

    public class AlbumsViewHolder extends RecyclerView.ViewHolder {

        TextView userid, id, title;
        MaterialCardView cardAlbums;


        public AlbumsViewHolder(@NonNull View itemView) {
            super(itemView);
            userid=itemView.findViewById(R.id.AuserId);
            id=itemView.findViewById(R.id.Aid);
            title=itemView.findViewById(R.id.Ptitle);
            cardAlbums=itemView.findViewById(R.id.cardAlbums);
        }
    }
}
