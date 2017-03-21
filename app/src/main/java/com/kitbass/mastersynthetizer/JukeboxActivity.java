package com.kitbass.mastersynthetizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class JukeboxActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jukebox);

        //Initialize and load the ad
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-8265447561352564~1386695531");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        List<Data> data = fillWithData();

        recyclerView = (RecyclerView) findViewById(R.id.heenokRecyclerView);
        adapter = new RecyclerViewAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        //recyclerView.addItemDecoration(new SpacesItemDecoration(1));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    }

    public List<Data> fillWithData() {
        List<Data> data = new ArrayList<>();

        data.add(new Data(R.drawable.brla));
        data.add(new Data(R.drawable.bwah));
        data.add(new Data(R.drawable.calotte));
        data.add(new Data(R.drawable.calotte2));
        data.add(new Data(R.drawable.des_choses_que_japprends));
        data.add(new Data(R.drawable.desert_eagle));
        data.add(new Data(R.drawable.font_aucun_revenu));
        data.add(new Data(R.drawable.hadeledil));
        data.add(new Data(R.drawable.han));
        data.add(new Data(R.drawable.hydroponique));
        data.add(new Data(R.drawable.ils_croivent_cest_un_jeu));
        data.add(new Data(R.drawable.ils_pesent_rien));
        data.add(new Data(R.drawable.jai_un_cadeau));
        data.add(new Data(R.drawable.jte_donne_de_lamour));
        data.add(new Data(R.drawable.jtrouve_que_cest_pete));
        data.add(new Data(R.drawable.jviens_dun_autre_dimension));
        data.add(new Data(R.drawable.la_frousse));
        data.add(new Data(R.drawable.la_sorbonne));
        data.add(new Data(R.drawable.le_balafre));
        data.add(new Data(R.drawable.le_dictionnaire));
        data.add(new Data(R.drawable.les_choses_se_passent_a_fond));
        data.add(new Data(R.drawable.mal_a_la_tete));
        data.add(new Data(R.drawable.medaillon));
        data.add(new Data(R.drawable.michael_tyson));
        data.add(new Data(R.drawable.migraines_de_fou));
        data.add(new Data(R.drawable.moins_que_100_dollars));
        data.add(new Data(R.drawable.montreal_paris));
        data.add(new Data(R.drawable.ouah));
        data.add(new Data(R.drawable.paname_queens_bridge));
        data.add(new Data(R.drawable.pomme));
        data.add(new Data(R.drawable.pti_pd));
        data.add(new Data(R.drawable.qecqs_passe));
        data.add(new Data(R.drawable.qecqs_putain_de_passe));
        data.add(new Data(R.drawable.rap_classique));
        data.add(new Data(R.drawable.revent_a_cela));
        data.add(new Data(R.drawable.seulement_ma_convention));
        data.add(new Data(R.drawable.seulement_mon_equipe));
        data.add(new Data(R.drawable.street_life));
        data.add(new Data(R.drawable.t_entends1));
        data.add(new Data(R.drawable.tentends_pute_negre));
        data.add(new Data(R.drawable.tes_pas_dla_famille));
        data.add(new Data(R.drawable.un_cadeau));
        data.add(new Data(R.drawable.un_cadeau_pour_mon_ami));
        data.add(new Data(R.drawable.une_page_a_lheure));;
        data.add(new Data(R.drawable.soon));

        return data;
    }
}
