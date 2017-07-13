package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Date;

/**
 * Created by Sergo on 09.07.2017.
 */

public class ContentFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        Button updateButton = (Button)view.findViewById(R.id.updateButton);
        final TextView updateBox = (TextView)view.findViewById(R.id.textBox) ;
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = new Date().toString();
                updateBox.setText(date);
            }
        });
        return view;
    }
}
