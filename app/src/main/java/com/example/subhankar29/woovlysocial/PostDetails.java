package com.example.subhankar29.woovlysocial;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.subhankar29.woovlysocial.adapters.CommentAdapter;
import com.example.subhankar29.woovlysocial.adapters.RetrofitAdapter;
import com.example.subhankar29.woovlysocial.model.Comment;
import com.example.subhankar29.woovlysocial.model.JsonPlaceHolderAPI;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.subhankar29.woovlysocial.PostListingScreen.EXTRA_ID;
import static com.example.subhankar29.woovlysocial.PostListingScreen.EXTRA_URL;

public class PostDetails extends AppCompatActivity {

    private static final String TAG = "POST DETAILS ACTIVITY";

    List<Comment> itemList = new ArrayList<>();
    CommentAdapter adapter;
    RecyclerView recyclerView;
    int id;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        Log.d(TAG, "onCreate Started");
        init();
    }

    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView imageView =findViewById(R.id.image);
        TextView name = findViewById(R.id.name);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        id = intent.getIntExtra(EXTRA_ID, 0);


        Picasso.get().load(imageUrl)
                .into(imageView);
        name.setText("User Id: " + id);

        JsonPlaceHolderAPI jsonPlaceHolderAPI = RetrofitAdapter.getInstance().create(JsonPlaceHolderAPI.class);

        Call<List<Comment>> call = jsonPlaceHolderAPI.getComments();

        callMethod(call);

    }

    private void callMethod(Call<List<Comment>> call){

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Error in connecting with server", Toast.LENGTH_LONG).show();
                }

                List<Comment> comments = response.body();

                //To populate all the details in the recyclerView:
                for (Comment comment : comments){
                    if(comment.getPostId() == id)
                    {
                        itemList.add(
                                new Comment(
                                        comment.getName(),
                                        comment.getEmail(),
                                        comment.getBody()
                                ));
                    }

                }

                //creating recyclerView adapter
                adapter = new CommentAdapter(PostDetails.this, itemList);

                //setting adapter to recyclerView
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }

        });
    }

}
