package com.boldijarpaul.mvprxsample.service;

import com.boldijarpaul.mvprxsample.mvp.model.JokesListModel;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by cicipapoi on 11/12/15.
 */
public interface JokeListApiService {
    @GET("/random/{count}")
    public Observable<JokesListModel> getJokesList(@Path("count") int count);
}
