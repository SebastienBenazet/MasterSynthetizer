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

        // Initialize soundboard images
        initializeSoundboardImages();

        //imgResourcesHeenok.add(this.getResources().getIdentifier("soon","drawable",getPackageName()));

        GridView gridView = (GridView) findViewById(R.id.heenok_grid_view);
        gridView.setAdapter(new ImageListAdapter(PicassoActivity.this, imgResourcesHeenok));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
            }

        });
    }
//
//    public void playSound(View v) {
//        if (loaded) {
//            String soundFileName = v.getTag().toString();
//            this.soundPool.play(soundResIds.get(soundFileName), 1, 1, 1, 0, 1);
//        }
//    }

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
