package com.boldijarpaul.mvprxsample.mvp.view;

import com.boldijarpaul.mvprxsample.mvp.model.JokesListModel;

/**
 * Created by cicipapoi on 11/12/15.
 */
public interface JokesListView {
    void showJokesList(JokesListModel jokesList);

    void showError(String error);

}
