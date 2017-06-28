package com.example.fragmentandsynk;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.zip.Inflater;

/**
 * Created by Home on 28.06.2017.
 */

public class ContentFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contaner, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_content,contaner, false);
        Button updateButton = (Button) view.findViewById(R.id.updateButton);
        final TextView updateBox = (TextView) view.findViewById(R.id.textBox);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curUpdate = new Date().toString();
                updateBox.setText(curUpdate);
            }
        });
        return view;
    }
}
