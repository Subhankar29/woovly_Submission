package com.example.subhankar29.woovlysocial.model;

import com.example.subhankar29.woovlysocial.model.Comment;
import com.example.subhankar29.woovlysocial.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {

    @GET("photos")
    Call<List<Post>> getPosts();

    @GET("comments")
    Call<List<Comment>> getComments();

}
