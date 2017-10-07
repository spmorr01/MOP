package com.willydevelopment.com.mopoliticsmoproblems;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity {

    ArrayList<TweetModel> tweetModels;
    ListView listView;
    private static TweetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView=(ListView)findViewById(R.id.list);

        tweetModels = new ArrayList<>();

        tweetModels.add(new TweetModel("Spencer Morris", "@smorris1", "1hr","This is great with no politics."));
        tweetModels.add(new TweetModel("Seth Morris", "@smorris2", "2hr","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"));
        tweetModels.add(new TweetModel("Joey Lenihan", "@jlenihan", "3hr","You suck."));
        tweetModels.add(new TweetModel("Dalton McQueen","@dmcqueen","4hr","I am dalton. hehe"));
        tweetModels.add(new TweetModel("Katie Morris", "@kmorris", "5hr","Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."));
        tweetModels.add(new TweetModel("Joey Lenihan", "@jlenihan", "8hr","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"));
        tweetModels.add(new TweetModel("Seth Morris", "@smorris2", "9hr","The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested."));
        tweetModels.add(new TweetModel("Spencer Morris","@smorris1","11hr","Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."));
        tweetModels.add(new TweetModel("Katie Morris", "@kmorris", "14hr","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"));
        tweetModels.add(new TweetModel("Joey Lenihan", "@jlenihan", "16hr","The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested."));
        tweetModels.add(new TweetModel("Dalton McQueen", "@dmcqueen", "19hr","Are you serious?"));
        tweetModels.add(new TweetModel("Seth Morris","@smorris2","21hr","Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."));
        tweetModels.add(new TweetModel("Logan Morris", "@lmorris", "23hr","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book"));

        adapter= new TweetAdapter(tweetModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TweetModel tweetModel = tweetModels.get(position);

                Snackbar.make(view, tweetModel.getDisplayName()+"\n"+tweetModel.getTwitterHandle()+" API: "+tweetModel.getTweetTime(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}