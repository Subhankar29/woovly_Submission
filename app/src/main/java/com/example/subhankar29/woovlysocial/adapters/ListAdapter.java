package com.example.subhankar29.woovlysocial.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.subhankar29.woovlysocial.model.Post;
import com.example.subhankar29.woovlysocial.R;
import com.squareup.picasso.Picasso;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {


    private Context mCtx;
    private List<Post> postList;
    private onItemClickListener mListener;


    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener;
    }

    public ListAdapter(Context ctx, List<Post> postList) {
        mCtx = ctx;
        this.postList = postList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_item, null);
        LayoutInflater.from(parent.getContext())
                      .inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Post post = postList.get(position);
        holder.albumId.setText("Album ID: " + post.getAlbumID());
        holder.ID.setText("USER ID: " + post.getId());
        holder.title.setText("Description: " + post.getTitle());

        final int id = post.getId();

        Picasso.get().load(post.getThumbnailUrl())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView albumId,ID, title;
        ImageView img;
        RelativeLayout parentLayout;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            albumId = itemView.findViewById(R.id.AlbumID);
            ID = itemView.findViewById(R.id.ID);
            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.imageView);
            parentLayout = itemView.findViewById(R.id.parentLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }

                    }
                }
            });

        }
    }

}
