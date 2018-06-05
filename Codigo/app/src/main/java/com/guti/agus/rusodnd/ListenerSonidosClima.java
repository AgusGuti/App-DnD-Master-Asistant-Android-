package com.guti.agus.rusodnd;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.io.IOException;

/**
 * Created by Ruso-Note on 20/2/2018.
 */

public class ListenerSonidosClima implements View.OnClickListener, Runnable  {


    private Activity activity;
    private Reproductor reproductorClima;
    private CheckBox checkClima;
//    private Handler handler;
    private Thread thread = new Thread(this);
    private int pista = 0;

    public ListenerSonidosClima(Activity activity, Reproductor reproductorClima, CheckBox checkClima)
    {this.activity = activity; this.reproductorClima = reproductorClima; this.checkClima = checkClima;}

    boolean loop;

    @Override
    public void onClick(View view) {

        loop = this.checkClima.isChecked();

        switch (((Spinner) activity.findViewById(R.id.spinnerClima)).getSelectedItem().toString())
        {
            case "Ventoso":

                pista = R.raw.ventoso;
                thread.run();

                break;

            case "Lluvioso":

                pista = R.raw.lightrain;
                thread.run();

                break;

            case "Tormenta":

                pista = R.raw.tormentoso;
                thread.run();

                break;

            case "Ventisca":

            pista = R.raw.ventisca;
            thread.run();

            break;

            case "Tormenta arena":

                pista = R.raw.sandstorm;
                thread.run();

                break;

            case "Caminar en barro":

                pista = R.raw.barrocaminar;
                thread.run();

                break;

            case "Caminar en nieve":

                pista = R.raw.nievecaminar;
                thread.run();

                break;
        }

    }


    @Override
    public void run() {
        try {
            reproductorClima.lanzar(activity, pista, loop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
