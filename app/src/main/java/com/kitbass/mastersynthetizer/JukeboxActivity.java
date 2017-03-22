package com.kitbass.mastersynthetizer;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JukeboxActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private AdView mAdView;
    private SoundPool soundPool;
    private boolean loaded;
    private static final int MAX_STREAMS = 7;
    private Map<String, Integer> soundResIds;

    private static final String PRECEDING_SOUNDS_FILENAME_STRING = "heenok_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jukebox);

        soundResIds = new HashMap<>();

        //Initialize and load the ad
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

        loadHeenokSounds();
        // On rempli le recycler view des images associées aux sons
        List<Data> data = fillWithData();

        recyclerView = (RecyclerView) findViewById(R.id.heenokRecyclerView);
        adapter = new RecyclerViewAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnItemTouchListener(new CustomRVItemTouchListener(this, recyclerView, new RecyclerViewItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                // Jouer le son ICI
                playSound(position);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "Long click", Toast.LENGTH_SHORT).show();
            }
        }));
        //recyclerView.addItemDecoration(new SpacesItemDecoration(1));

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    }


    public List<Data> fillWithData() {
        List<Data> data = new ArrayList<>();

        Field[] fields = R.raw.class.getFields();
        int numberOfHeenokSounds = 0;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().startsWith(PRECEDING_SOUNDS_FILENAME_STRING)) {
                numberOfHeenokSounds++;
            }
        }

        for (int i = 1; i < numberOfHeenokSounds + 1; i++) {
            data.add(new Data(
                            this.getResources().getIdentifier(PRECEDING_SOUNDS_FILENAME_STRING + i, "drawable", getPackageName()),
                            this.getResources().getIdentifier(PRECEDING_SOUNDS_FILENAME_STRING + i, "raw", getPackageName())
                    )
            );
        }

        data.add(new Data(R.drawable.soon, R.raw.heenok_1));
        return data;
    }


    /* Helper methods */
    private void loadHeenokSounds() {
        Field[] fields = R.raw.class.getFields();
        int numberOfHeenokSounds = 0;
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().startsWith(PRECEDING_SOUNDS_FILENAME_STRING))
                numberOfHeenokSounds++;
        }

        int tempSoundPool;
        String tempSoundFileName;
        for (int i = 1; i < numberOfHeenokSounds + 1; i++) {
            tempSoundFileName = PRECEDING_SOUNDS_FILENAME_STRING + i;
            tempSoundPool = this.soundPool.load(this, this.getResources().getIdentifier(tempSoundFileName, "raw", getPackageName()), 1);
            soundResIds.put(tempSoundFileName, tempSoundPool);
        }
    }

    /* TODO : Play sound depending on item position */
    private void playSound(int position) {
        String soundFileName = PRECEDING_SOUNDS_FILENAME_STRING + (position + 1);
        this.soundPool.play(soundResIds.get(soundFileName), 1, 1, 1, 0, 1);
    }
}
