package com.boldijarpaul.mvprxsample.mvp.view;

import com.boldijarpaul.mvprxsample.mvp.model.JokeModel;

/**
 * Created by cicipapoi on 11/12/15.
 */
public interface JokeView {

    void showJoke(JokeModel joke);

    void showError(String error);
}
