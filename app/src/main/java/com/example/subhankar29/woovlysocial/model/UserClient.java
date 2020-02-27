package com.example.subhankar29.woovlysocial.model;

import com.example.subhankar29.woovlysocial.model.Login;
import com.example.subhankar29.woovlysocial.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserClient {

    @POST("login")
    Call<User> login(@Body Login login);

    @GET("secretinfo")
    Call<ResponseBody> getSecret(@Header("Authorization") String authToken);

}
