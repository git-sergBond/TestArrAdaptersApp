package com.example.home.testarradaptersapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassification;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Home on 26.06.2017.
 */

public class ProductAdapter extends ArrayAdapter<Product>{
    private LayoutInflater inFlater;
    private int layout;
    private ArrayList<Product> productList;

    public ProductAdapter(Context context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.inFlater = LayoutInflater.from(context);
        this.layout = resource;
        this.productList = products;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        final ViewHolder viewHolder;
        if(convertView == null){
            convertView = inFlater.inflate(layout,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        final Product product = productList.get(position);
        viewHolder.nameView.setText(product.getName());
        viewHolder.countView.setText(formatValue(product.getCount(),product.getUnit()));
        viewHolder.remuveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = product.getCount()-1;
                if(count<0) {
                    count = 0;
                }
                product.setCount(count);
                viewHolder.countView.setText(formatValue(product.getCount(),product.getUnit()));
            }
        });
        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = product.getCount()+1;
                product.setCount(count);
                viewHolder.countView.setText(formatValue(product.getCount(),product.getUnit()));
            }
        });
        return convertView;
    }

    private String formatValue(int count, String unit){
        return String.valueOf(count) + " " + unit;
    }

    private class ViewHolder{
        final Button addButton, remuveButton;
        final TextView nameView, countView;
        ViewHolder(View view){
            addButton = (Button)view.findViewById(R.id.addButton);
            remuveButton = (Button)view.findViewById(R.id.removeButton);
            nameView = (TextView)view.findViewById(R.id.nameView);
            countView = (TextView)view.findViewById(R.id.countView);
        }
    }
}
