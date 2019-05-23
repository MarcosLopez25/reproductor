package com.example.reproductor.reproductor;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

public class ReproductorActivity extends AppCompatActivity {

    MediaPlayer vectorM[] = new MediaPlayer[6];
    MediaController.MediaPlayerControl mp;
    int posicion=0;
    Button btnPlay_Pause, btnStop, btnPrev, btnNext;
    ImageView portada;
    TextView txtTitulo, txtArtista;

    int[] imagen ={
            R.drawable.ifeeling,
            R.drawable.feel,
            R.drawable.bag,
            R.drawable.like,
            R.drawable.black,
            R.drawable.crush
    };

    String [][] info = {
            {"I Feel It Coming", "The Weeknd, Daft Punk"},
            {"Feels", "Calvin Harris"},
            {"BagBak", "Vince Staples"},
            {"That's What I Like", "Bruno Mars"},
            {"Paramedic!", "SOB X RBE"},
            {"Instant Crush", "Daft Punk, Julian Casablancas"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        btnStop = findViewById(R.id.btnStop);
        btnPlay_Pause = findViewById(R.id.btnPlay_Pause);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        portada = findViewById(R.id.imgPortada);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtArtista = findViewById(R.id.txtArtista);

        vectorM[0] = MediaPlayer.create(this, R.raw.ifeeling);
        txtTitulo.setText(info[0][0]);
        txtArtista.setText(info[0][1]);
        vectorM[1] = MediaPlayer.create(this, R.raw.feels);
        vectorM[2] = MediaPlayer.create(this, R.raw.bag);
        vectorM[3] = MediaPlayer.create(this, R.raw.like);
        vectorM[4] = MediaPlayer.create(this, R.raw.black);
        vectorM[5] = MediaPlayer.create(this, R.raw.crush);

        btnPlay_Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vectorM[posicion].isPlaying()){
                    vectorM[posicion].pause();
                    btnPlay_Pause.setBackgroundResource(R.drawable.play);
                    Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
                }else{
                    vectorM[posicion].start();
                    btnPlay_Pause.setBackgroundResource(R.drawable.pause);
                    Toast.makeText(getApplicationContext(), "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vectorM[posicion] != null){
                    vectorM[posicion].stop();

                    vectorM[0] = MediaPlayer.create(getApplicationContext(), R.raw.ifeeling);
                    vectorM[1] = MediaPlayer.create(getApplicationContext(), R.raw.feels);
                    vectorM[2] = MediaPlayer.create(getApplicationContext(), R.raw.bag);
                    vectorM[3] = MediaPlayer.create(getApplicationContext(), R.raw.like);
                    vectorM[4] = MediaPlayer.create(getApplicationContext(), R.raw.black);
                    vectorM[5] = MediaPlayer.create(getApplicationContext(), R.raw.crush);
                    posicion = 0;
                    btnPlay_Pause.setBackgroundResource(R.drawable.play);
                    portada.setImageResource(R.drawable.ifeeling);
                    txtTitulo.setText(info[0][0]);
                    txtArtista.setText(info[0][1]);
                    Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posicion < vectorM.length -1){
                    if(vectorM[posicion].isPlaying()){
                        vectorM[posicion].stop();
                        posicion++;
                        vectorM[posicion].start();

                        if(posicion == 0){
                            portada.setImageResource(imagen[0]);
                            txtTitulo.setText(info[0][0]);
                            txtArtista.setText(info[0][1]);
                        } else if(posicion == 1){
                            portada.setImageResource(imagen[1]);
                            txtTitulo.setText(info[1][0]);
                            txtArtista.setText(info[1][1]);
                        } else if(posicion == 2){
                            portada.setImageResource(imagen[2]);
                            txtTitulo.setText(info[2][0]);
                            txtArtista.setText(info[2][1]);
                        } else if(posicion == 3){
                            portada.setImageResource(imagen[3]);
                            txtTitulo.setText(info[3][0]);
                            txtArtista.setText(info[3][1]);
                        } else if(posicion == 4){
                            portada.setImageResource(imagen[4]);
                            txtTitulo.setText(info[4][0]);
                            txtArtista.setText(info[4][1]);
                        } else if(posicion == 5){
                            portada.setImageResource(imagen[5]);
                            txtTitulo.setText(info[5][0]);
                            txtArtista.setText(info[5][1]);
                        }
                    } else{
                        posicion++;

                        if(posicion == 0){
                            portada.setImageResource(imagen[0]);
                            txtTitulo.setText(info[0][0]);
                            txtArtista.setText(info[0][1]);
                        } else if(posicion == 1){
                            portada.setImageResource(imagen[1]);
                            txtTitulo.setText(info[1][0]);
                            txtArtista.setText(info[1][1]);
                        } else if(posicion == 2){
                            portada.setImageResource(imagen[2]);
                            txtTitulo.setText(info[2][0]);
                            txtArtista.setText(info[2][1]);
                        } else if(posicion == 3){
                            portada.setImageResource(imagen[3]);
                            txtTitulo.setText(info[3][0]);
                            txtArtista.setText(info[3][1]);
                        } else if(posicion == 4){
                            portada.setImageResource(imagen[4]);
                            txtTitulo.setText(info[4][0]);
                            txtArtista.setText(info[4][1]);
                        } else if(posicion == 5){
                            portada.setImageResource(imagen[5]);
                            txtTitulo.setText(info[5][0]);
                            txtArtista.setText(info[5][1]);
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No hay más canciones",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posicion >= 1){
                    if(vectorM[posicion].isPlaying()){
                        vectorM[posicion].stop();
                        vectorM[0] = MediaPlayer.create(getApplicationContext(),R.raw.ifeeling);
                        vectorM[1] = MediaPlayer.create(getApplicationContext(),R.raw.feels);
                        vectorM[2] = MediaPlayer.create(getApplicationContext(),R.raw.bag);
                        vectorM[3] = MediaPlayer.create(getApplicationContext(),R.raw.like);
                        vectorM[4] = MediaPlayer.create(getApplicationContext(),R.raw.black);
                        vectorM[5] = MediaPlayer.create(getApplicationContext(),R.raw.crush);
                        posicion--;
                        vectorM[posicion].start();

                        if(posicion == 0){
                            portada.setImageResource(imagen[0]);
                            txtTitulo.setText(info[0][0]);
                            txtArtista.setText(info[0][1]);
                        } else if(posicion == 1){
                            portada.setImageResource(imagen[1]);
                            txtTitulo.setText(info[1][0]);
                            txtArtista.setText(info[1][1]);
                        } else if(posicion == 2){
                            portada.setImageResource(imagen[2]);
                            txtTitulo.setText(info[2][0]);
                            txtArtista.setText(info[2][1]);
                        } else if(posicion == 3){
                            portada.setImageResource(imagen[3]);
                            txtTitulo.setText(info[3][0]);
                            txtArtista.setText(info[3][1]);
                        } else if(posicion == 4){
                            portada.setImageResource(imagen[4]);
                            txtTitulo.setText(info[4][0]);
                            txtArtista.setText(info[4][1]);
                        } else if(posicion == 5){
                            portada.setImageResource(imagen[5]);
                            txtTitulo.setText(info[5][0]);
                            txtArtista.setText(info[5][1]);
                        }
                    } else{
                      posicion--;

                        if(posicion == 0){
                            portada.setImageResource(imagen[0]);
                            txtTitulo.setText(info[0][0]);
                            txtArtista.setText(info[0][1]);
                        } else if(posicion == 1){
                            portada.setImageResource(imagen[1]);
                            txtTitulo.setText(info[1][0]);
                            txtArtista.setText(info[1][1]);
                        } else if(posicion == 2){
                            portada.setImageResource(imagen[2]);
                            txtTitulo.setText(info[2][0]);
                            txtArtista.setText(info[2][1]);
                        } else if(posicion == 3){
                            portada.setImageResource(imagen[3]);
                            txtTitulo.setText(info[3][0]);
                            txtArtista.setText(info[3][1]);
                        } else if(posicion == 4){
                            portada.setImageResource(imagen[4]);
                            txtTitulo.setText(info[4][0]);
                            txtArtista.setText(info[4][1]);
                        } else if(posicion == 5){
                            portada.setImageResource(imagen[5]);
                            txtTitulo.setText(info[5][0]);
                            txtArtista.setText(info[5][1]);
                        }
                    }
                } else{
                    Toast.makeText(getApplicationContext(), "No hay más canciones", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
