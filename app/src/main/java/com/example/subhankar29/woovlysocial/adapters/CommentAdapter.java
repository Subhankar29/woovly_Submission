package com.example.subhankar29.woovlysocial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.subhankar29.woovlysocial.model.Comment;
import com.example.subhankar29.woovlysocial.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private Context mCtx;
    private List<Comment> commentList;

    public CommentAdapter(Context ctx, List<Comment> commentList) {
        mCtx = ctx;
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.comment_card, null);
        return new CommentAdapter.CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {

        Comment comment = commentList.get(position);

        holder.name.setText("Name: " + comment.getName());
        holder.email.setText("Email: " + comment.getEmail());
        holder.body.setText("Description: " + comment.getBody());

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }


    class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView name, email, body;


        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);


        }
    }
}
