package com.example.fragmentandsynk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.actLayout, new ContentFragment(getLayoutInflater(),R.id.actLayout,savedInstanceState)).commit();
        }
    }
}
