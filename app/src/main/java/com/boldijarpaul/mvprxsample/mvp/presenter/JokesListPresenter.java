package com.boldijarpaul.mvprxsample.mvp.presenter;

import android.content.Context;

import com.boldijarpaul.mvprxsample.dagger.DaggerApp;
import com.boldijarpaul.mvprxsample.mvp.model.JokeModel;
import com.boldijarpaul.mvprxsample.mvp.model.JokesListModel;
import com.boldijarpaul.mvprxsample.mvp.view.JokesListView;
import com.boldijarpaul.mvprxsample.rx.RxPresenter;
import com.boldijarpaul.mvprxsample.service.JokeApiService;
import com.boldijarpaul.mvprxsample.service.JokeListApiService;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cicipapoi on 11/12/15.
 */
public class JokesListPresenter extends RxPresenter<JokesListView> {

    public static final int COUNT_JOKES = 10;

    @Inject
    JokeListApiService mJokeListApiService;


    public JokesListPresenter(JokesListView view, Context context) {
        super(view);
        DaggerApp.get(context).graph().inject(this);
    }

    public void loadJokeList() {
        mJokeListApiService.getJokesList(COUNT_JOKES)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokesListModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(JokesListModel jokesListModel) {
                        getView().showJokesList(jokesListModel);
                    }
                });
    }

}
