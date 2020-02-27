package com.example.subhankar29.woovlysocial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.subhankar29.woovlysocial.adapters.ListAdapter;
import com.example.subhankar29.woovlysocial.adapters.RetrofitAdapter;
import com.example.subhankar29.woovlysocial.model.JsonPlaceHolderAPI;
import com.example.subhankar29.woovlysocial.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostListingScreen extends AppCompatActivity implements ListAdapter.onItemClickListener  {

    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_ID = "id";

    RecyclerView recyclerView;
    List<Post> itemList = new ArrayList<>();
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_listing_screen);
        init();
    }

    private void init() {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        JsonPlaceHolderAPI jsonPlaceHolderAPI = RetrofitAdapter.getInstance().create(JsonPlaceHolderAPI.class);

        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts();

        callMethod(call);
    }

    private void callMethod(Call<List<Post>> call) {

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {


                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Error in conneting with server", Toast.LENGTH_LONG).show();
                }

                List<Post> posts = response.body();


                //To populate all the details in the recycler view:
                for (Post post : posts){


                    itemList.add(
                            new Post(
                                    post.getAlbumID(),
                                    post.getId(),
                                    post.getTitle(),
                                    post.getThumbnailUrl()
                            ));

                }

                //creating recyclerview adapter
                adapter = new ListAdapter(getApplicationContext(), itemList);

                //setting adapter to recyclerview
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(PostListingScreen.this);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(int position) {

        Intent detailIntent = new Intent(this, PostDetails.class);
        Post postItem = itemList.get(position);

        detailIntent.putExtra(EXTRA_URL, postItem.getThumbnailUrl());
        detailIntent.putExtra(EXTRA_ID, postItem.getId());

        startActivity(detailIntent);
    }
}
