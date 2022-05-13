package com.example.translator;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    Button button1, button2, button3, button4, button5, button6, button7, button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tuparlesanglais);
                mediaPlayer.start();

                SeekBar scrubSeekbar = (SeekBar) findViewById(R.id.scrubSeekbar);
                scrubSeekbar.setMax(mediaPlayer.getDuration());
                scrubSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        Log.i("Info", Integer.toString(i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        scrubSeekbar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                }, 0, 1);

                mediaPlayer.setOnCompletionListener((new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                       Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                       startActivity(intent);
                    }
                }));
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bonsoir);
                mediaPlayer.start();
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bonjour);
                mediaPlayer.start();
            }
        });

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.commentallezvous);
                mediaPlayer.start();
            }
        });

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.jhabitea);
                mediaPlayer.start();
            }
        });

        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.jemappelle);
                mediaPlayer.start();
            }
        });

        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.silvousplait);
                mediaPlayer.start();
            }
        });

        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.derien);
                mediaPlayer.start();
            }
        });

    }
}