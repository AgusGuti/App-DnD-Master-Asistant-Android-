package com.guti.agus.rusodnd;


import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;

import java.io.IOException;

/**
 * Created by Ruso-Note on 20/2/2018.
 */

public class ListenerDados implements View.OnClickListener, Runnable {

    private TextView txt;
    private Reproductor reproductorClima;
    private Reproductor reproductorAmbiente;
    private Reproductor reproductorEfectos;
    private Handler handler;

    public ListenerDados (TextView texto, Reproductor reproductorAmbiente, Reproductor reproductorClima, Reproductor reproductorEfectos, Handler handler)
    {this.txt = texto; this.reproductorAmbiente = reproductorAmbiente;
        this.reproductorClima = reproductorClima; this.reproductorEfectos = reproductorEfectos; this.handler = handler;}

    private int limite = 0;
    private double resultado = 0;
    private Thread thread = new Thread(this);


    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.clr_bttn) {

            try {
                reproductorAmbiente.parar();
                reproductorClima.parar();
                reproductorEfectos.parar();
            } catch (IOException e) {
                e.printStackTrace();
            }

            txt.setText("");
        }
        else
        {
            switch (v.getId()) {
                case R.id.d4_bttn:
                    limite = 5;
                    break;

                case R.id.d6_bttn:
                    limite = 7;
                    break;

                case R.id.d8_bttn:
                    limite = 9;
                    break;

                case R.id.d12_bttn:
                    limite = 13;
                    break;

                case R.id.d20_bttn:
                    limite = 21;
                    break;
            }


                thread.run();

        }
    }

    @Override
    public void run() {

//        for (int i = 0; i<5; i++)
//            {
                resultado = Math.random() * limite;

                if (resultado < 1)
                    resultado++;

                sendMsg(resultado);

//                try{
//                    Thread.sleep(1000);
//                }catch(InterruptedException e){}
//            }
    }


    private void sendMsg (double resultado)
    {
        Message message = new Message();
        message.obj = Integer.toString((int) resultado);
        handler.sendMessage(message);
    }
}
