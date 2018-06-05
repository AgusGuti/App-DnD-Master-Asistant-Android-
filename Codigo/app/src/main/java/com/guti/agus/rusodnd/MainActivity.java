package com.guti.agus.rusodnd;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

public class MainActivity extends AppCompatActivity implements android.os.Handler.Callback {

     Reproductor reproductorAmbiente = new Reproductor();
     Reproductor reproductorClima = new Reproductor();
     Reproductor reproductorEfectos = new Reproductor();

    //Metodo alternativo usando lista de players
//     private MediaPlayer[]  players = new MediaPlayer[3];

     private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmento_principal);

        //Metodo alternativo usando lista de players
//        MediaPlayer reproductorAmbiente = players[0];
//        MediaPlayer reproductorClima = players[1];
//        MediaPlayer reproductorEfectos = players[2];


        handler = new Handler(this);


        TextView visor = (TextView) findViewById(R.id.visor_txt);
        ImageButton d4 = (ImageButton) findViewById(R.id.d4_bttn);
        ImageButton d6 = (ImageButton) findViewById(R.id.d6_bttn);
        ImageButton d8 = (ImageButton) findViewById(R.id.d8_bttn);
        ImageButton d12 = (ImageButton) findViewById(R.id.d12_bttn);
        ImageButton d20 = (ImageButton) findViewById(R.id.d20_bttn);
        ImageButton reproducirAmbiente = (ImageButton) findViewById(R.id.play_ambiente_bttn);
        ImageButton reproducirClima = (ImageButton) findViewById(R.id.play_clima_bttn);
        ImageButton reproducirEfectos = (ImageButton) findViewById(R.id.play_efectos_bttn);
        Button limpiarBoton = (Button) findViewById(R.id.clr_bttn);
        CheckBox checkAmbiente = (CheckBox) findViewById(R.id.loopAmbiente_check);
        CheckBox checkClima = (CheckBox) findViewById(R.id.loopClima_check);
        CheckBox checkEfectos = (CheckBox) findViewById(R.id.loopEfectos_check);



        try {
            reproductorEfectos.lanzar(this,R.raw.intro, checkEfectos.isChecked());
        } catch (IOException e) {
            e.printStackTrace();
        }


        ListenerDados listenerDados = new ListenerDados(visor, reproductorAmbiente, reproductorClima, reproductorEfectos, handler);
        ListenerMusicaAmbiente listenerMusicaAmbiente = new ListenerMusicaAmbiente(this, reproductorAmbiente, checkAmbiente);
        ListenerSonidosClima listenerSonidosClima = new ListenerSonidosClima(this, reproductorClima,checkClima);
        ListenerSonidosEfectos listenerSonidosEfectos = new ListenerSonidosEfectos (this, reproductorEfectos, checkEfectos);


        d4.setOnClickListener(listenerDados);
        d6.setOnClickListener(listenerDados);
        d8.setOnClickListener(listenerDados);
        d12.setOnClickListener(listenerDados);
        d20.setOnClickListener(listenerDados);
        limpiarBoton.setOnClickListener(listenerDados);
        reproducirAmbiente.setOnClickListener(listenerMusicaAmbiente);
        reproducirClima.setOnClickListener(listenerSonidosClima);
        reproducirEfectos.setOnClickListener(listenerSonidosEfectos);



        //Spinner de Ambiente

        List<String> listaMusicaAmbiente = new ArrayList<String>();
        listaMusicaAmbiente.add("Ambiente");
        listaMusicaAmbiente.add("Aventura");
        listaMusicaAmbiente.add("Bosque");
        listaMusicaAmbiente.add("Desierto");
        listaMusicaAmbiente.add("Cueva humeda");
        listaMusicaAmbiente.add("Cueva profunda");
        listaMusicaAmbiente.add("Turba iracunda");
        listaMusicaAmbiente.add("Ciudad");
        listaMusicaAmbiente.add("Sonido taberna");
        listaMusicaAmbiente.add("Musica taberna");
        listaMusicaAmbiente.add("Barco tormenta");
        listaMusicaAmbiente.add("Coro demoniaco");
        listaMusicaAmbiente.add("Susurro fantasma");


        ArrayAdapter<String> adapterSpinnerAmbiente = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, listaMusicaAmbiente);

        Spinner spinnerMusicaAmbiente = (Spinner) findViewById(R.id.spinnerAmbiente);
        spinnerMusicaAmbiente.setAdapter(adapterSpinnerAmbiente);
        spinnerMusicaAmbiente.setSelection(0);



        //Spinner de Clima

        List<String> listaMusicaClima = new ArrayList<String>();
        listaMusicaClima.add("Clima");
        listaMusicaClima.add("Ventoso");
        listaMusicaClima.add("Lluvioso");
        listaMusicaClima.add("Tormenta");
        listaMusicaClima.add("Ventisca");
        listaMusicaClima.add("Tormenta arena");
        listaMusicaClima.add("Caminar en barro");
        listaMusicaClima.add("Caminar en nieve");

        ArrayAdapter<String> adapterSpinnerClima = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, listaMusicaClima);

        Spinner spinnerMusicaClima = (Spinner) findViewById(R.id.spinnerClima);
        spinnerMusicaClima.setAdapter(adapterSpinnerClima);
        spinnerMusicaClima.setSelection(0);


        //Spinner de Efectos

        List<String> listaSonidosEfectos = new ArrayList<String>();
        listaSonidosEfectos.add("Efectos");
        listaSonidosEfectos.add("Errar golpe");
        listaSonidosEfectos.add("Golpe");
        listaSonidosEfectos.add("Espada");
        listaSonidosEfectos.add("Hacha");
        listaSonidosEfectos.add("Flecha");
        listaSonidosEfectos.add("Conjuro");
        listaSonidosEfectos.add("Bola de fuego");
        listaSonidosEfectos.add("Rayo");
        listaSonidosEfectos.add("Abrir cerrojo");
        listaSonidosEfectos.add("Abrir puerta");
        listaSonidosEfectos.add("Cerrar puerta");
        listaSonidosEfectos.add("Canto demoniaco");
        listaSonidosEfectos.add("Acecha felino");
        listaSonidosEfectos.add("Acecha oso");
        listaSonidosEfectos.add("Ataca trasgo");
        listaSonidosEfectos.add("Ataca ogro");
//        listaSonidosEfectos.add("Ataca espectro");


        ArrayAdapter<String> adapterSpinnerEfectos = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, listaSonidosEfectos);

        Spinner spinnerSonidosEfectos = (Spinner) findViewById(R.id.spinnerEfectos);
        spinnerSonidosEfectos.setAdapter(adapterSpinnerEfectos);
        spinnerSonidosEfectos.setSelection(0);
    }


    @Override
    public boolean handleMessage(Message message) {

        String text = (String) message.obj;
        TextView visor = (TextView) findViewById(R.id.visor_txt);
        visor.setText(text);

        return true;
    }


    @Override
    protected void onResume () {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        reproductorClima.pausar();
        reproductorAmbiente.pausar();
        reproductorEfectos.pausar();
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            reproductorClima.parar();
            reproductorAmbiente.parar();
            reproductorEfectos.parar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


