package com.guti.agus.rusodnd;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.io.IOException;

/**
 * Created by Ruso-Note on 22/2/2018.
 */

class ListenerSonidosEfectos implements View.OnClickListener, Runnable  {


    private Activity activity;
    private Reproductor reproductorEfectos;
    private CheckBox checkEfectos;
//    private Handler handler;
    private Thread thread = new Thread(this);
    private int pista = 0;

    public ListenerSonidosEfectos(Activity activity, Reproductor reproductorEfectos, CheckBox checkEfectos)
    {this.activity = activity; this.reproductorEfectos = reproductorEfectos; this.checkEfectos = checkEfectos;}

    boolean loop;

    @Override
    public void onClick(View view) {

        loop = this.checkEfectos.isChecked();

        switch (((Spinner) activity.findViewById(R.id.spinnerEfectos)).getSelectedItem().toString())
        {
            case "Errar golpe":

                pista = R.raw.errargolpe;
                thread.run();

                break;

            case "Golpe":

                pista = R.raw.trompazo;
                thread.run();

                break;

            case "Espada":

                pista = R.raw.golpeespada;
                thread.run();

                break;

            case "Hacha":

                pista = R.raw.hachazo;
                thread.run();

                break;

            case "Flecha":

                pista = R.raw.flecha;
                thread.run();

                break;

            case "Conjuro":

                 pista = R.raw.conjuroofensivo;
                thread.run();

                break;

            case "Bola de fuego":

                pista = R.raw.boladefuego;
                thread.run();

                break;

            case "Rayo":

                pista = R.raw.rayo;
                thread.run();

                break;

            case "Abrir cerrojo":

                pista = R.raw.cerraduraabrir;
                thread.run();

                break;

            case "Abrir puerta":

                pista = R.raw.puertaabrir;
                thread.run();

                break;

            case "Cerrar puerta":

                pista = R.raw.puertacerrar;
                thread.run();

                break;

            case "Canto demoniaco":

                pista = R.raw.conjurodemoniaco;
                thread.run();

                break;

            case "Acecha felino":

                pista = R.raw.felinoacecha;
                thread.run();

                break;

            case "Acecha oso":

                pista = R.raw.oso;
                thread.run();

                break;

            case "Ataca trasgo":

                pista = R.raw.trasgoataca;
                thread.run();

                break;

            case "Ataca ogro":

                pista = R.raw.ogro;
                thread.run();

                break;

//            case "Ataca espectro":
//
//                pista = R.raw.espectro;
//                thread.run();
//
//                break;
        }

    }


    @Override
    public void run() {
        try {
            reproductorEfectos.lanzar(activity, pista, loop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

