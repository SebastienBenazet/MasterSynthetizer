package com.kitbass.mastersynthetizer;

import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

import static com.kitbass.mastersynthetizer.PicassoActivity.soundResourcesHeenok;

public class JukeboxActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SoundPool soundPool;
    private static boolean loaded;
    private AdView mAdView;

    private static final int MAX_STREAMS = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jukebox2);

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

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Drawable[] myDataset = getHeenokDrawables();

        mAdapter = new MyAdapter(myDataset, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    /* Helper methods */
    private Drawable[] getHeenokDrawables() {
        try {
            // Load heenok json
            InputStream heenokSoundboardInputStream = getResources().openRawResource(R.raw.soundboard_heenok);
            JSONObject soundboardJson = Helpers.loadJsonFromInputStream(heenokSoundboardInputStream);

            JSONArray imagesSounds = soundboardJson.getJSONObject("Soundboard").getJSONArray("ImagesSounds");
            int imagesSoundsCount = imagesSounds.length();

            // Json parsing
            JSONObject tempImageSound;
            Drawable[] heenokDrawables = new Drawable[imagesSoundsCount];
            Integer[] soundResourcesHeenok = new Integer[imagesSoundsCount];
            Integer tempDrawableResources;
            Integer tempSoundResource;
            for (int i = 0; i < imagesSoundsCount; i++) {
                tempImageSound = imagesSounds.getJSONObject(i);
                tempDrawableResources = (this
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
                heenokDrawables[i] = getResources().getDrawable(tempDrawableResources);
            }
            return heenokDrawables;
        } catch (JSONException e) {
            e.printStackTrace();
        
        return null;
    }

    public void playSound(int position) {
        if (loaded)
            soundPool.play(soundResourcesHeenok[position], 1, 1, 1, 0, 1);
    }
}