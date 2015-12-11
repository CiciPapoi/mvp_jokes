package com.boldijarpaul.mvprxsample.dagger;


import com.boldijarpaul.mvprxsample.activities.MainActivity;
import com.boldijarpaul.mvprxsample.mvp.presenter.JokePresenter;
import com.boldijarpaul.mvprxsample.mvp.presenter.JokesListPresenter;

public interface DaggerGraph {
    void inject(DaggerApp daggerApp);

    void inject(MainActivity mainActivity);

    void inject(JokePresenter jokePresenter);

    void inject(JokesListPresenter jokesListPresenter);
}
