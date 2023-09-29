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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    Context context;
    List<PostModel>postModelList;

    public PostAdapter(Context context, List<PostModel> postModelList) {
        this.context = context;
        this.postModelList = postModelList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel postModel=postModelList.get(position);
        holder.userId.setText("User id:"+postModel.getUserId());
        holder.id.setText("id:"+postModel.getId());
        holder.title.setText("title:"+postModel.getTitle());
        holder.body.setText("body:"+postModel.getBody());

        holder.postCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,CommentActivity.class);
                i.putExtra("userId",postModel.getUserId());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        });
        


    }

    @Override
    public int getItemCount() {
        return postModelList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView userId, id,title,body;
        MaterialCardView postCard;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userId=itemView.findViewById(R.id.txtIdUser);
            id=itemView.findViewById(R.id.txtId);
            title=itemView.findViewById(R.id.txtTitle);
            body=itemView.findViewById(R.id.txtBody);
            postCard=itemView.findViewById(R.id.postCard);
        }
    }
}
