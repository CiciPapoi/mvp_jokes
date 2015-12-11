package com.boldijarpaul.mvprxsample.mvp.presenter;

import android.content.Context;

import com.boldijarpaul.mvprxsample.dagger.DaggerApp;
import com.boldijarpaul.mvprxsample.mvp.model.JokeModel;
import com.boldijarpaul.mvprxsample.mvp.view.JokeView;
import com.boldijarpaul.mvprxsample.rx.RxPresenter;
import com.boldijarpaul.mvprxsample.service.JokeApiService;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cicipapoi on 11/12/15.
 */
public class JokePresenter extends RxPresenter<JokeView> {

    @Inject
    JokeApiService mJokeApiService;

    public JokePresenter(JokeView view, Context context) {
        super(view);
        DaggerApp.get(context).graph().inject(this);
    }

    public void loadJoke() {
        mJokeApiService.getRandomJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(JokeModel jokeModel) {
                        getView().showJoke(jokeModel);
                    }
                });
    }


    public void loadJoke(String firstName, String lastName) {
        mJokeApiService.getRandomJokeWithName(firstName, lastName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(JokeModel jokeModel) {
                        getView().showJoke(jokeModel);
                    }
                });
    }

}
