package com.kitbass.mastersynthetizer;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HeenokActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private boolean loaded;
    // Maximumn sound stream.
    private static final int MAX_STREAMS = 7;

    private int soundIdBrla;
    private int soundIdCalotte;
    private int soundIdCalotte2;
    private int soundIdAucunRevenu;
    private int soundIdHan1;
    private int soundIdIlsCroivent;
    private int soundIdPesentRien;
    private int soundIdDonneAmour;
    private int soundIdCestPete;
    private int soundIdAutreDimension;
    private int soundIdFrousse;
    private int soundIdSorbonne;
    private int soundIdBalafre;
    private int soundIdDictionnaire;
    private int soundIdPassentAFont;
    private int soundIdMedaillon;
    private int soundIdTyson;
    private int soundId100Dollars;
    private int soundIdMontreal;
    private int soundIdHydroponique;
    private int soundIdPomme;
    private int soundIdPtiPD;
    private int soundIdRapClassique;
    private int soundIdReventACela;
    private int soundIdConvention;
    private int soundIdEquipe;
    private int soundIdStreeLife;
    private int soundIdTentends;
    private int soundIdFamille;
    private int soundIdBwah;
    private int soundIdChosesQueJapprends;
    private int soundIdDesertEagle;
    private int soundIdHadeledil;
    private int soundIdJaiUnCadeau;
    private int soundIdMalALaTete;
    private int soundIdMigraines;
    private int soundIdOuah;
    private int soundIdPaname;
    private int soundIdQecqsPasse;
    private int soundIdQecqsPutainPasse;
    private int soundIdTentendsPuteNegre;
    private int soundIdUnCadeau;
    private int soundIdUnCadeauAmi;
    private int soundIdPageALheure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heenok);


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

        this.soundIdBrla = this.soundPool.load(this, R.raw.brla, 1);
        this.soundIdCalotte = this.soundPool.load(this, R.raw.calotte, 1);
        this.soundIdCalotte2 = this.soundPool.load(this, R.raw.calotte2, 1);
        this.soundIdAucunRevenu = this.soundPool.load(this, R.raw.font_aucun_revenu, 1);
        this.soundIdHan1 = this.soundPool.load(this, R.raw.han1, 1);
        this.soundIdIlsCroivent = this.soundPool.load(this, R.raw.ils_croivent_cest_un_jeu, 1);
        this.soundIdPesentRien = this.soundPool.load(this, R.raw.ils_pesent_rien, 1);
        this.soundIdDonneAmour = this.soundPool.load(this, R.raw.jte_donne_de_lamour, 1);
        this.soundIdCestPete = this.soundPool.load(this, R.raw.jtrouve_que_cest_pete, 1);
        this.soundIdAutreDimension = this.soundPool.load(this, R.raw.jviens_dun_autre_dimension, 1);
        this.soundIdFrousse = this.soundPool.load(this, R.raw.la_frousse, 1);
        this.soundIdSorbonne = this.soundPool.load(this, R.raw.la_sorbonne, 1);
        this.soundIdBalafre = this.soundPool.load(this, R.raw.le_balafre, 1);
        this.soundIdDictionnaire = this.soundPool.load(this, R.raw.le_dictionnaire, 1);
        this.soundIdPassentAFont = this.soundPool.load(this, R.raw.les_choses_se_passent_a_fond, 1);
        this.soundIdMedaillon = this.soundPool.load(this, R.raw.medaillon, 1);
        this.soundIdTyson = this.soundPool.load(this, R.raw.michael_tyson, 1);
        this.soundId100Dollars = this.soundPool.load(this, R.raw.moins_que_100_dollars, 1);
        this.soundIdMontreal = this.soundPool.load(this, R.raw.montreal_paris, 1);
        this.soundIdHydroponique = this.soundPool.load(this, R.raw.ou_est_lhydroponique, 1);
        this.soundIdPomme = this.soundPool.load(this, R.raw.pomme, 1);
        this.soundIdPtiPD = this.soundPool.load(this, R.raw.pti_pd, 1);
        this.soundIdRapClassique = this.soundPool.load(this, R.raw.rap_classique, 1);
        this.soundIdReventACela = this.soundPool.load(this, R.raw.revent_a_cela, 1);
        this.soundIdConvention = this.soundPool.load(this, R.raw.seulement_ma_convention, 1);
        this.soundIdEquipe = this.soundPool.load(this, R.raw.seulement_mon_equipe, 1);
        this.soundIdStreeLife = this.soundPool.load(this, R.raw.street_life, 1);
        this.soundIdTentends = this.soundPool.load(this, R.raw.t_entends1, 1);;
        this.soundIdFamille = this.soundPool.load(this, R.raw.tes_pas_de_la_famille, 1);
        this.soundIdBwah = this.soundPool.load(this, R.raw.bwah, 1);
        this.soundIdChosesQueJapprends = this.soundPool.load(this, R.raw.des_choses_que_japprends, 1);
        this.soundIdDesertEagle = this.soundPool.load(this, R.raw.desert_eagle, 1);
        this.soundIdHadeledil = this.soundPool.load(this, R.raw.hadeledil, 1);
        this.soundIdJaiUnCadeau = this.soundPool.load(this, R.raw.jai_un_cadeau, 1);
        this.soundIdMalALaTete = this.soundPool.load(this, R.raw.mal_a_la_tete, 1);
        this.soundIdMigraines = this.soundPool.load(this, R.raw.migraines_de_fou, 1);
        this.soundIdOuah = this.soundPool.load(this, R.raw.ouah, 1);
        this.soundIdPaname = this.soundPool.load(this, R.raw.paname_queens_bridge, 1);
        this.soundIdQecqsPasse = this.soundPool.load(this, R.raw.qecqs_passe, 1);
        this.soundIdQecqsPutainPasse = this.soundPool.load(this, R.raw.qecqs_putain_de_passe, 1);
        this.soundIdTentendsPuteNegre = this.soundPool.load(this, R.raw.tentends_pute_negre, 1);
        this.soundIdUnCadeau = this.soundPool.load(this, R.raw.un_cadeau, 1);
        this.soundIdUnCadeauAmi = this.soundPool.load(this, R.raw.un_cadeau_pour_mon_ami, 1);
        this.soundIdPageALheure = this.soundPool.load(this, R.raw.une_page_a_lheure, 1);
    }

    public void onSoundButtonClick(View v) {
        switch (v.getId()) {
            case (R.id.heenok_brla_button):
                if (loaded) this.soundPool.play(this.soundIdBrla, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_medaillon_button):
                if (loaded) this.soundPool.play(this.soundIdMedaillon, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_revenu_button):
                if (loaded) this.soundPool.play(this.soundIdAucunRevenu, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_han_button):
                if (loaded) this.soundPool.play(this.soundIdHan1, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_croivent_button):
                if (loaded) this.soundPool.play(this.soundIdIlsCroivent, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_pesent_button):
                if (loaded) this.soundPool.play(this.soundIdPesentRien, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_100dollars_button):
                if (loaded) this.soundPool.play(this.soundId100Dollars, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_montrealparis_button):
                if (loaded) this.soundPool.play(this.soundIdMontreal, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_hydroponique_button):
                if (loaded) this.soundPool.play(this.soundIdHydroponique, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_pomme_button):
                if (loaded) this.soundPool.play(this.soundIdPomme, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_revent_button):
                if (loaded) this.soundPool.play(this.soundIdReventACela, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_convention_button):
                if (loaded) this.soundPool.play(this.soundIdConvention, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_equipe_button):
                if (loaded) this.soundPool.play(this.soundIdEquipe, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_famille_button):
                if (loaded) this.soundPool.play(this.soundIdFamille, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_calotte_button):
                if (loaded) this.soundPool.play(this.soundIdCalotte, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_tentends1_button):
                if (loaded) this.soundPool.play(this.soundIdTentends, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_ptipd_button):
                if (loaded) this.soundPool.play(this.soundIdPtiPD, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_rapclassic_button):
                if (loaded) this.soundPool.play(this.soundIdRapClassique, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_calotte2_button):
                if (loaded) this.soundPool.play(this.soundIdCalotte2, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_streetlife_button):
                if (loaded) this.soundPool.play(this.soundIdStreeLife, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_donnedelamour_button):
                if (loaded) this.soundPool.play(this.soundIdDonneAmour, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_cestpete_button):
                if (loaded) this.soundPool.play(this.soundIdCestPete, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_autredimension_button):
                if (loaded) this.soundPool.play(this.soundIdAutreDimension, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_frousse_button):
                if (loaded) this.soundPool.play(this.soundIdFrousse, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_sorbonne_button):
                if (loaded) this.soundPool.play(this.soundIdSorbonne, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_balafre_button):
                if (loaded) this.soundPool.play(this.soundIdBalafre, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_dictionnaire_button):
                if (loaded) this.soundPool.play(this.soundIdDictionnaire, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_chosessepassent_button):
                if (loaded) this.soundPool.play(this.soundIdPassentAFont, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_tyson_button):
                if (loaded) this.soundPool.play(this.soundIdTyson, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_bwah_button):
                if (loaded) this.soundPool.play(this.soundIdBwah, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_chosesquejapprends_button):
                if (loaded) this.soundPool.play(this.soundIdChosesQueJapprends, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_deserteagle_button):
                if (loaded) this.soundPool.play(this.soundIdDesertEagle, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_hadeledil_button):
                if (loaded) this.soundPool.play(this.soundIdHadeledil, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_jaiuncadeau_button):
                if (loaded) this.soundPool.play(this.soundIdJaiUnCadeau, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_malalatete_button):
                if (loaded) this.soundPool.play(this.soundIdMalALaTete, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_migraines_button):
                if (loaded) this.soundPool.play(this.soundIdMigraines, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_ouah_button):
                if (loaded) this.soundPool.play(this.soundIdOuah, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_paname_button):
                if (loaded) this.soundPool.play(this.soundIdPaname, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_qecqspasse_button):
                if (loaded) this.soundPool.play(this.soundIdQecqsPasse, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_qecqsputainpasse_button):
                if (loaded) this.soundPool.play(this.soundIdQecqsPutainPasse, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_tentendsputenegre_button):
                if (loaded) this.soundPool.play(this.soundIdTentendsPuteNegre, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_uncadeau_button):
                if (loaded) this.soundPool.play(this.soundIdUnCadeau, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_uncadeaupourmonami_button):
                if (loaded) this.soundPool.play(this.soundIdUnCadeauAmi, 1, 1, 1, 0, 1);
                break;
            case (R.id.heenok_unepagealheure_button):
                if (loaded) this.soundPool.play(this.soundIdPageALheure, 1, 1, 1, 0, 1);
                break;
        }
    }
}
