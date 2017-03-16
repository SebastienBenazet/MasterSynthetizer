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
//            case (R.id.heenok_chevilles_button):
//                Toast.makeText(getApplicationContext(), "Not yet !", Toast.LENGTH_SHORT).show();
//                break;
            case (R.id.heenok_brla_button):
                final MediaPlayer brla = MediaPlayer.create(this, R.raw.brla);
                brla.start();
                break;
            case (R.id.heenok_medaillon_button):
                final MediaPlayer medaillon = MediaPlayer.create(this, R.raw.medaillon);
                medaillon.start();
                break;
//            case (R.id.heenok_negros_button):
//                Toast.makeText(getApplicationContext(), "Not yet !", Toast.LENGTH_SHORT).show();
//                break;
//            case (R.id.heenok_montres_button):
//                Toast.makeText(getApplicationContext(), "Not yet !", Toast.LENGTH_SHORT).show();
//                break;
//            case (R.id.heenok_houhou_button):
//                Toast.makeText(getApplicationContext(), "Not yet !", Toast.LENGTH_SHORT).show();
//                break;
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
            case (R.id.heenok_calotte_button):
                final MediaPlayer calotte = MediaPlayer.create(this, R.raw.calotte);
                calotte.start();
                break;
            case (R.id.heenok_tentends1_button):
                final MediaPlayer tentends1 = MediaPlayer.create(this, R.raw.t_entends1);
                tentends1.start();
                break;
            case (R.id.heenok_ptipd_button):
                final MediaPlayer ptipd = MediaPlayer.create(this, R.raw.pti_pd);
                ptipd.start();
                break;
            case (R.id.heenok_calotte2_button):
                final MediaPlayer calotte2 = MediaPlayer.create(this, R.raw.calotte2);
                calotte2.start();
                break;
            case (R.id.heenok_streetlife_button):
                final MediaPlayer streetlife = MediaPlayer.create(this, R.raw.street_life);
                streetlife.start();
                break;
            case (R.id.heenok_donnedelamour_button):
                final MediaPlayer donnelamour = MediaPlayer.create(this, R.raw.jte_donne_de_lamour);
                donnelamour.start();
                break;
            case (R.id.heenok_cestpete_button):
                final MediaPlayer cestpete = MediaPlayer.create(this, R.raw.jtrouve_que_cest_pete);
                cestpete.start();
                break;
            case (R.id.heenok_autredimension_button):
                final MediaPlayer autredimension = MediaPlayer.create(this, R.raw.jviens_dun_autre_dimension);
                autredimension.start();
                break;
            case (R.id.heenok_frousse_button):
                final MediaPlayer frousse = MediaPlayer.create(this, R.raw.la_frousse);
                frousse.start();
                break;
            case (R.id.heenok_sorbonne_button):
                final MediaPlayer sorbonne = MediaPlayer.create(this, R.raw.la_sorbonne);
                sorbonne.start();
                break;
            case (R.id.heenok_balafre_button):
                final MediaPlayer balafre = MediaPlayer.create(this, R.raw.le_balafre);
                balafre.start();
                break;
            case (R.id.heenok_dictionnaire_button):
                final MediaPlayer dictionnaire = MediaPlayer.create(this, R.raw.le_dictionnaire);
                dictionnaire.start();
                break;
            case (R.id.heenok_chosessepassent_button):
                final MediaPlayer chosessepassent = MediaPlayer.create(this, R.raw.les_choses_se_passent_a_fond);
                chosessepassent.start();
                break;
            case (R.id.heenok_tyson_button):
                final MediaPlayer tyson = MediaPlayer.create(this, R.raw.michael_tyson);
                tyson.start();
                break;
            case (R.id.heenok_rapclassic_button):
                final MediaPlayer rapclassic = MediaPlayer.create(this, R.raw.rap_classique);
                rapclassic.start();
                break;
        }
    }
}
