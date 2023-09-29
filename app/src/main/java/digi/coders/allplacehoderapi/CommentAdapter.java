package digi.coders.allplacehoderapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    Context context;
    List<CommentModel>commentModelList;

    public CommentAdapter(Context context, List<CommentModel> commentModelList) {
        this.context = context;
        this.commentModelList = commentModelList;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        CommentModel commentModel=commentModelList.get(position);
        holder.postId.setText("Post ID:"+commentModel.getPostId());
        holder.id.setText("ID:"+commentModel.getId());
        holder.name.setText("Name:"+commentModel.getName());
        holder.email.setText("Email:"+commentModel.getEmail());
        holder.body.setText("Body:"+commentModel.getBody());

    }

    @Override
    public int getItemCount() {
        return commentModelList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView postId, id, name , email, body;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            postId=itemView.findViewById(R.id.txt_postId);
            id=itemView.findViewById(R.id.txt_id);
            name=itemView.findViewById(R.id.txt_name);
            email=itemView.findViewById(R.id.txt_email);
            body=itemView.findViewById(R.id.txt_body);

        }
    }
}
