package com.example.fragmentandsynk;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;

/**
 * Created by Home on 29.06.2017.
 */

public class ListFrag extends Fragment {
    OnFragmentInteractionListener mListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contaner, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.list_fragment,contaner,false);
        Button btn = view.findViewById(R.id.updateButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curDate = new Date().toString();
                mListener.onFragmentInteraction(curDate);
            }
        });
        return view;
    }
    interface OnFragmentInteractionListener{
        void onFragmentInteraction(String link);
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            mListener = (OnFragmentInteractionListener)context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
}
