package com.kitbass.mastersynthetizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;


public class PicassoActivity extends AppCompatActivity {

    public static Integer[] imgResourcesHeenok;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        // Initialize and load the ad
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8265447561352564~1386695531");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Initialize soundboard images
        initializeSoundboardImages();

        //imgResourcesHeenok.add(this.getResources().getIdentifier("soon","drawable",getPackageName()));

        GridView gridView = (GridView) findViewById(R.id.heenok_grid_view);
        gridView.setAdapter(new ImageListAdapter(PicassoActivity.this, imgResourcesHeenok));
    }

    public void onSoundButtonClick(View view) {
        Toast.makeText(getApplicationContext(), "Coming soon !", Toast.LENGTH_SHORT).show();
    }


    /* Helper methods */
    private void initializeSoundboardImages() {
        try {
            // Load heenok json
            InputStream heenokSoundboardInputStream = getResources().openRawResource(R.raw.soundboard_heenok);
            JSONObject soundboardJson = Helpers.loadJsonFromInputStream(heenokSoundboardInputStream);

            JSONArray imagesSounds = soundboardJson.getJSONObject("Soundboard").getJSONArray("ImagesSounds");
            int imagesSoundsCount = imagesSounds.length();

            // Json parsing
            JSONObject tempImageSound;
            imgResourcesHeenok = new Integer[imagesSoundsCount];
            for (int i = 0; i < imagesSoundsCount; i++) {
                tempImageSound = imagesSounds.getJSONObject(i);
                imgResourcesHeenok[i] = (this
                        .getResources()
                        .getIdentifier(tempImageSound.getString("ImageFileName"),
                                "drawable",
                                getPackageName()
                        )
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
