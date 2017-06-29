package com.example.fragmentandsynk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Home on 29.06.2017.
 */

public class ContFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contaner, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.content_fragment,contaner,false);
        return view;
    }
    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(item);
    }
}
