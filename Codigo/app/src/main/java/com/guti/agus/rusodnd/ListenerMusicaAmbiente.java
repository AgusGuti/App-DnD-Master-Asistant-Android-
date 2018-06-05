package com.guti.agus.rusodnd;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.io.IOException;

/**
 * Created by Ruso-Note on 20/2/2018.
 */

public class ListenerMusicaAmbiente implements View.OnClickListener, Runnable  {

    private Activity activity;
    private Reproductor reproductorAmbiente;
    private CheckBox checkAmbiente;
//    private Handler handler;
    private Thread thread = new Thread(this);

    private int pista = 0;


    public ListenerMusicaAmbiente(Activity activity, Reproductor reproductorAmbiente, CheckBox checkAmbiente)
    {this.activity = activity; this.reproductorAmbiente = reproductorAmbiente; this.checkAmbiente = checkAmbiente;}

    boolean loop;

    @Override
    public void onClick(View view) {

        loop = this.checkAmbiente.isChecked();

        switch (((Spinner)activity.findViewById(R.id.spinnerAmbiente)).getSelectedItem().toString())
        {
            case "Aventura":

                pista = R.raw.thefellowshiptheme;

                break;

            case "Bosque":

                pista = R.raw.bosque;

                break;

            case "Desierto":

                pista = R.raw.desierto;

                break;

            case "Cueva humeda":

                pista = R.raw.cuevahumeda;

                break;

            case "Cueva profunda":

                pista = R.raw.deepcave;
                break;

            case "Turba iracunda":

                pista = R.raw.angrymob;

                break;

            case "Ciudad":

                pista = R.raw.ciudadmedieval40seg;

                break;

            case "Sonido taberna":

                pista = R.raw.taverna40seg;

                break;

            case "Musica taberna":

                pista = R.raw.tavernmusic;

                break;

            case "Barco tormenta":

                pista = R.raw.barcotormenta;

                break;

            case "Coro demoniaco":

                pista = R.raw.corodemoniaco;

                break;

            case "Susurro fantasma":

                pista = R.raw.susurrofantasma;

                break;
        }


        thread.run();

    }

    @Override
    public void run() {
        try {
            reproductorAmbiente.lanzar(activity, pista, loop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}