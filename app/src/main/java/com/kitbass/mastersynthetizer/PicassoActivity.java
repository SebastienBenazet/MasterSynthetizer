package com.kitbass.mastersynthetizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;


public class PicassoActivity extends AppCompatActivity {

    private static final String PRECEDING_HEENOK_FILENAME_STRING = "heenok_";

    public static Integer[] imgResourcesHeenok;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        //Initialize and load the ad
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8265447561352564~1386695531");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        List<Integer> tempImgHeenok = new ArrayList<>();
        for (int i = 1; i < 45; i++) {
            tempImgHeenok.add(this
                    .getResources()
                    .getIdentifier(PRECEDING_HEENOK_FILENAME_STRING + i,
                            "drawable",
                            getPackageName()
                    )
            );
        }

        tempImgHeenok.add(this.getResources().getIdentifier("soon","drawable",getPackageName()));
        imgResourcesHeenok = Helpers.convertIntegerArrayListToArray(tempImgHeenok);

        GridView gridView = (GridView) findViewById(R.id.heenok_grid_view);
        gridView.setAdapter(new ImageListAdapter(PicassoActivity.this, imgResourcesHeenok));
    }

    public void onSoundButtonClick(View view) {
        Toast.makeText(getApplicationContext(), "Coming soon !", Toast.LENGTH_SHORT).show();
    }
}
