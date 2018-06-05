package com.guti.agus.rusodnd;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by Ruso-Note on 21/2/2018.
 */

public class Reproductor {

    private MediaPlayer player = new MediaPlayer();
    boolean creado = false;

    public void lanzar(Activity activity, int pista, boolean loop) throws IOException {

        if (!creado){}

        if (!player.isPlaying()){

            try{
                player = MediaPlayer.create(activity, pista);
//
//              player.setDataSource(activity, Uri.parse("android.resource://raw/" + pista));
//              player.prepare();
//              player.prepareAsync();

                player.start();
                player.setLooping(loop);

//              player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mediaPlayer) {
//                    mediaPlayer.start();
//                }
//            });

//
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });
            }catch (Exception e){e.printStackTrace();}

        }
        else
        {
            this.parar();
        }
    };


    public void parar () throws IOException {
        try {
            player.stop();
            player.reset();
            player.prepare();
            player.release();
            player = null;
        }catch (Exception e){e.printStackTrace();}
    }

    public void pausar ()
    {
        player.pause();
    }


}

