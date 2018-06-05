package com.guti.agus.rusodnd;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruso-Note on 21/2/2018.
 */

public class FragmentoPrincipal extends Fragment {

    public View OnCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

//        TextView visor = (TextView) getActivity().findViewById(R.id.visor_txt);
//        ImageButton d4 = (ImageButton) getActivity().findViewById(R.id.d4_bttn);
//        ImageButton d6 = (ImageButton) getActivity().findViewById(R.id.d6_bttn);
//        ImageButton d8 = (ImageButton) getActivity().findViewById(R.id.d8_bttn);
//        ImageButton d12 = (ImageButton) getActivity().findViewById(R.id.d12_bttn);
//        ImageButton d20 = (ImageButton) getActivity().findViewById(R.id.d20_bttn);
//        ImageButton reproducirClima = (ImageButton) getActivity().findViewById(R.id.play_clima_bttn);
//        ImageButton reproducirAmbiente = (ImageButton) getActivity().findViewById(R.id.play_ambiente_bttn);
//        Button limpiarBoton = (Button) getActivity().findViewById(R.id.clr_bttn);
//
//        ListenerSonidosClima listenerSonidosClima = new ListenerSonidosClima();
//
//        ListenerDados listenerDados = new ListenerDados(visor);
//
//        d4.setOnClickListener(listenerDados);
//        d6.setOnClickListener(listenerDados);
//        d8.setOnClickListener(listenerDados);
//        d12.setOnClickListener(listenerDados);
//        d20.setOnClickListener(listenerDados);
//        limpiarBoton.setOnClickListener(listenerDados);
//       // reproducirAmbiente.setOnClickListener(this);
//        reproducirClima.setOnClickListener(listenerSonidosClima);
//
//        //Spinner de Ambiente
//
//        List<String> listaMusicaAmbiente = new ArrayList<String>();
//        listaMusicaAmbiente.add("Ambiente");
//        listaMusicaAmbiente.add("Aventura");
//        listaMusicaAmbiente.add("Bosque");
//        listaMusicaAmbiente.add("Ciudad");
//        listaMusicaAmbiente.add("Cueva humeda");
//        listaMusicaAmbiente.add("Sonido taverna");
//        listaMusicaAmbiente.add("Musica taverna");
//
//        ArrayAdapter<String> adapterSpinnerAmbiente = new ArrayAdapter<String>
//                (getActivity(), R.layout.support_simple_spinner_dropdown_item, listaMusicaAmbiente);
//
//
//        Spinner spinnerMusicaAmbiente = (Spinner) getActivity().findViewById(R.id.spinnerAmbiente);
//        spinnerMusicaAmbiente.setAdapter(adapterSpinnerAmbiente);
//        spinnerMusicaAmbiente.setSelection(0);
//
//        //Spinner de Clima
//
//        List<String> listaMusicaClima = new ArrayList<String>();
//        listaMusicaClima.add("Clima");
//        listaMusicaClima.add("Ventoso");
//        listaMusicaClima.add("Lluvioso");
//        listaMusicaClima.add("Tormenta");
//
//        ArrayAdapter<String> adapterSpinnerClima = new ArrayAdapter<String>
//                (getActivity(), R.layout.support_simple_spinner_dropdown_item, listaMusicaClima);
//
//        Spinner spinnerMusicaClima = (Spinner) getActivity().findViewById(R.id.spinnerClima);
//        spinnerMusicaClima.setAdapter(adapterSpinnerClima);
//        spinnerMusicaClima.setSelection(0);
//
        return inflater.inflate(R.layout.fragmento_principal, container, false);
    }
}
