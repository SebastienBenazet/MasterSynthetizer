package com.kitbass.mastersynthetizer;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HeenokActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private boolean loaded;
    // Maximumn sound stream.
    private static final int MAX_STREAMS = 7;
    // Preceding string in sounds file names
    private static final String PRECEDING_SOUNDS_FILENAME_STRING = "heenok_";

    private Map<String, Integer> soundResIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heenok);
        soundResIds = new HashMap<String, Integer>();

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
    }

    public void onSoundButtonClick(View v) {
        if (loaded) {
            String soundFileName = v.getTag().toString();
            this.soundPool.play(soundResIds.get(soundFileName), 1, 1, 1, 0, 1);
        }
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
}
