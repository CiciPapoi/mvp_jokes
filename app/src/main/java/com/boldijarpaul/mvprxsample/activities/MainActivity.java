package com.boldijarpaul.mvprxsample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boldijarpaul.mvprxsample.R;
import com.boldijarpaul.mvprxsample.mvp.model.JokeModel;
import com.boldijarpaul.mvprxsample.mvp.presenter.JokePresenter;
import com.boldijarpaul.mvprxsample.mvp.view.JokeView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements JokeView {

    private JokePresenter mJokePresenter;

    @Bind(R.id.jokeButton)
    Button mJokeButton;

    @Bind(R.id.nameJokeButton)
    Button mNameJokeButton;

    @Bind(R.id.jokeTextView)
    TextView mJoketextView;

    @Bind(R.id.nameJokeTextView)
    TextView mNameJokeTextView;

    @Bind(R.id.firstNameEditText)
    EditText mFirstNameEditText;

    @Bind(R.id.lastNameEditText)
    EditText mLastNameEditText;

    @Bind(R.id.mainNavigationButton)
    Button mNavigationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJokePresenter = new JokePresenter(this, this);
        mJokePresenter.wakeUp();

        ButterKnife.bind(this);

    }

    @OnClick(R.id.jokeButton)
    void onJokeButtonClicked(){
        mJokePresenter.loadJoke();
    }

    @OnClick(R.id.nameJokeButton)
    void onNameJokeButtonClicked(){
        mJokePresenter.loadJoke(mFirstNameEditText.getText().toString(), mLastNameEditText.getText().toString());
    }

    @OnClick(R.id.mainNavigationButton)
    void onNavigationButtonClicked(){
        Intent intent = new Intent(this, JokesActivity.class);
        startActivity(intent);
    }



    @Override
    public void showJoke(JokeModel joke) {
        mJoketextView.setText(joke.value.joke);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mJokePresenter.destroy();
    }
}
