package com.kitbass.mastersynthetizer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ViewHolder extends RecyclerView.ViewHolder {

    RelativeLayout relativeLayout;
    ImageView imageView;

    ViewHolder(View itemView) {
        super(itemView);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.heenokRelativeLayout);
        imageView = (ImageView) itemView.findViewById(R.id.heenokImageView);
    }
}

