package com.kitbass.mastersynthetizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ImageListAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private Integer[] imageResources;

    static class ViewHolder {
        ImageView mImageView;
    }

    public ImageListAdapter(Context context, Integer[] image) {
        super(context, R.layout.listview_item_image, image);

        this.context = context;
        this.imageResources = image;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // ViewHolder pattern in play
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_item_image, parent, false);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.iv_button);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Picasso
                .with(context)
                .load(imageResources[position])
                .fit()
                .centerInside()
                .into(viewHolder.mImageView);

        return convertView;
    }
}