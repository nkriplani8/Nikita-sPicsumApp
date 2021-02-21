package com.example.imageshow;

import com.example.imageshow.model.ImageFeed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("300/300")
    Call<List<ImageFeed>> getImages(@Query("image") String id);
    @GET("list")
    Call<List<ImageFeed>> getImages();

}
