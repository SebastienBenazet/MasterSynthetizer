package com.kitbass.mastersynthetizer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HeenokActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heenok);

        //Orientation de l'écran
        //Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        //System.out.println(display.getRotation());
    }


    public void onSoundButtonClick(View v) {
        switch (v.getId()) {
            case (R.id.heenok_chevilles_button):
                //Sound needed
                break;
            case (R.id.heenok_brla_button):
                //Sound needed
                break;
            case (R.id.heenok_medaillon_button):
                //Sound needed
                break;
            case (R.id.heenok_negros_button):
                //Sound needed
                break;
            case (R.id.heenok_montres_button):
                //Sound needed
                break;
            case (R.id.heenok_houhou_button):
                //Sound needed
                break;
            case (R.id.heenok_revenu_button):
                final MediaPlayer revenu = MediaPlayer.create(this, R.raw.font_aucun_revenu);
                revenu.start();
                break;
            case (R.id.heenok_han_button):
                final MediaPlayer han1 = MediaPlayer.create(this, R.raw.han1);
                han1.start();
                break;
            case (R.id.heenok_croivent_button):
                final MediaPlayer croivent = MediaPlayer.create(this, R.raw.ils_croivent_cest_un_jeu);
                croivent.start();
                break;
            case (R.id.heenok_pesent_button):
                final MediaPlayer pesent = MediaPlayer.create(this, R.raw.ils_pesent_rien);
                pesent.start();
                break;
            case (R.id.heenok_dimension_button):
                final MediaPlayer dimension = MediaPlayer.create(this, R.raw.jviens_dun_autre_dimension);
                dimension.start();
                break;
            case (R.id.heenok_100dollars_button):
                final MediaPlayer dollars = MediaPlayer.create(this, R.raw.moins_que_100_dollars);
                dollars.start();
                break;
            case (R.id.heenok_montrealparis_button):
                final MediaPlayer montreal = MediaPlayer.create(this, R.raw.montreal_paris);
                montreal.start();
                break;
            case (R.id.heenok_hydroponique_button):
                final MediaPlayer hydroponique = MediaPlayer.create(this, R.raw.ou_est_lhydroponique);
                hydroponique.start();
                break;
            case (R.id.heenok_pomme_button):
                final MediaPlayer pomme = MediaPlayer.create(this, R.raw.pomme);
                pomme.start();
                break;
            case (R.id.heenok_revent_button):
                final MediaPlayer revent = MediaPlayer.create(this, R.raw.revent_a_cela);
                revent.start();
                break;
            case (R.id.heenok_convention_button):
                final MediaPlayer convention = MediaPlayer.create(this, R.raw.seulement_ma_convention);
                convention.start();
                break;
            case (R.id.heenok_equipe_button):
                final MediaPlayer equipe = MediaPlayer.create(this, R.raw.seulement_mon_equipe);
                equipe.start();
                break;
            case (R.id.heenok_famille_button):
                final MediaPlayer famille = MediaPlayer.create(this, R.raw.tes_pas_de_la_famille);
                famille.start();
                break;
        }
    }
}
