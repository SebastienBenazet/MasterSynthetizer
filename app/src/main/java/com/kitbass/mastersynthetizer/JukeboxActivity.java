package com.kitbass.mastersynthetizer;

import android.graphics.drawable.Drawable;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

import static com.kitbass.mastersynthetizer.PicassoActivity.imgResourcesHeenok;

public class JukeboxActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jukebox2);

        // Initialize and load the ad
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8265447561352564~1386695531");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Get the drawables
        Drawable[] myDataset = getHeenokDrawables();

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int itemPosition = mRecyclerView.getChildLayoutPosition();
//                String item = mLayoutManager.get(itemPosition);
//                Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();
//            }
//        });
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
            Integer tempDrawableResources;
            for (int i = 0; i < imagesSoundsCount; i++) {
                tempImageSound = imagesSounds.getJSONObject(i);
                tempDrawableResources = (this
                        .getResources()
                        .getIdentifier(tempImageSound.getString("ImageFileName"),
                                "drawable",
                                getPackageName()
                        )
                );
                heenokDrawables[i] = getResources().getDrawable(tempDrawableResources);
            }
            return heenokDrawables;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
