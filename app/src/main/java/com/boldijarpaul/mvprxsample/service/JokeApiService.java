package com.boldijarpaul.mvprxsample.service;

import com.boldijarpaul.mvprxsample.mvp.model.JokeModel;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by cicipapoi on 11/12/15.
 */
public interface JokeApiService {
    @GET("/random")
    public Observable<JokeModel> getRandomJoke();

    @GET("/random")
    public Observable<JokeModel> getRandomJokeWithName(@Query("firstName") String firstName,
                                                       @Query("lastName") String lastName);
}
