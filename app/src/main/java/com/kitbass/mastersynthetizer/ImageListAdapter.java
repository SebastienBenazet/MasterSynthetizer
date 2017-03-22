package com.kitbass.mastersynthetizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private Integer[] imageRessources;

    public ImageListAdapter(Context context, Integer[] imageUrls) {
        super(context, R.layout.listview_item_image, imageUrls);

        this.context = context;
        this.imageRessources = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.listview_item_image, parent, false);
        }

        Picasso
                .with(context)
                .load(imageRessources[position])
                .fit()
                .centerInside()
                .into((ImageView) convertView);

        return convertView;
    }
}