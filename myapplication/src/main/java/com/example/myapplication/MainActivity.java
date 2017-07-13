package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnFragmentInteractionListener
{

    public static final String EXTRA_URL = "url";


    int clicks = 0;

    TextView clicksView;
    Button progressBtn, clicksBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicksView = (TextView) findViewById(R.id.clicksView);
        clicksBtn = (Button) findViewById(R.id.clicksBtn);
        clicksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                clicksView.setText("Clicks: " + clicks);
            }
        });

       /* if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment3, new ListFragment())
                    .commit();
        }*/
    }

    @Override
    public void onFragmentInteraction(String link) {
        DetailFragment fragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        //if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){
        if(fragment!=null && fragment.isInLayout()){
            fragment.setText(link);
        } else
            {
            Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
            intent.putExtra(EXTRA_URL,link);
            startActivity(intent);
        }
    }


}
