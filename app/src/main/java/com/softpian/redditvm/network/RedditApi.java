package com.softpian.redditvm.network;

import com.softpian.redditvm.model.RedditNewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RedditApi {

    @GET("top.json")
    Call<RedditNewsResponse> getTopPosts(@Query("after") String after, @Query("limit") String limit);
}
