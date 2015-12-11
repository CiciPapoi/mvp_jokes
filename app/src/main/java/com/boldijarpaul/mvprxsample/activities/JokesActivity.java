package com.boldijarpaul.mvprxsample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.boldijarpaul.mvprxsample.R;
import com.boldijarpaul.mvprxsample.mvp.model.JokesListModel;
import com.boldijarpaul.mvprxsample.mvp.presenter.JokesListPresenter;
import com.boldijarpaul.mvprxsample.mvp.view.JokesListView;

import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JokesActivity extends AppCompatActivity implements JokesListView{

    @Bind(R.id.jokesListView)
    ListView mJokesListView;

    public JokesListPresenter mJokesListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        ButterKnife.bind(this);

        mJokesListPresenter = new JokesListPresenter(this, this);
        mJokesListPresenter.wakeUp();
        mJokesListPresenter.loadJokeList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.jokes_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.menu_refresh) {
            mJokesListPresenter.loadJokeList();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showJokesList(JokesListModel jokesList) {
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jokesList.toStringArray());
        mJokesListView.setAdapter(itemsAdapter);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
