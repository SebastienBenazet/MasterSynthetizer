package com.kitbass.mastersynthetizer;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;


public class PicassoActivity extends AppCompatActivity {
    public static Integer[] imgResourcesHeenok;
    public static Integer[] soundResourcesHeenok;
    private AdView mAdView;
    private boolean loaded;
    private SoundPool soundPool;

    private static final int MAX_STREAMS = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        // Initialize and load the ad
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8265447561352564~1386695531");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if (Build.VERSION.SDK_INT >= 21) {
            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder = new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);
            this.soundPool = builder.build();
        } else {
            this.soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }

        // When Sound Pool load complete.
        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        // Initialize soundboard images and sounds
        initializeSoundboard();

        //imgResourcesHeenok.add(this.getResources().getIdentifier("soon","drawable",getPackageName()));

        GridView gridView = (GridView) findViewById(R.id.heenok_grid_view);
        gridView.setAdapter(new ImageListAdapter(PicassoActivity.this, imgResourcesHeenok));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (loaded)
                    soundPool.play(soundResourcesHeenok[position], 1, 1, 1, 0, 1);
            }
        });
    }

    /* Helper methods */
    private void initializeSoundboard() {
        try {
            // Load heenok json
            InputStream heenokSoundboardInputStream = getResources().openRawResource(R.raw.soundboard_heenok);
            JSONObject soundboardJson = Helpers.loadJsonFromInputStream(heenokSoundboardInputStream);

            JSONArray imagesSounds = soundboardJson.getJSONObject("Soundboard").getJSONArray("ImagesSounds");
            int imagesSoundsCount = imagesSounds.length();

            // Json parsing
            JSONObject tempImageSound;
            int tempSoundResource;
            imgResourcesHeenok = new Integer[imagesSoundsCount];
            soundResourcesHeenok = new Integer[imagesSoundsCount];
            for (int i = 0; i < imagesSoundsCount; i++) {
                tempImageSound = imagesSounds.getJSONObject(i);
                imgResourcesHeenok[i] = (this
                        .getResources()
                        .getIdentifier(tempImageSound.getString("ImageFileName"),
                                "drawable",
                                getPackageName()
                        )
                );

                tempSoundResource = (this
                        .getResources()
                        .getIdentifier(tempImageSound.getString("SoundFileName"),
                                "raw",
                                getPackageName()
                        )
                );
                soundResourcesHeenok[i] = this.soundPool.load(this, tempSoundResource, 1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
