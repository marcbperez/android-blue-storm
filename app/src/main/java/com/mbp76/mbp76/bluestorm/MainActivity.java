package com.marcbperez.marcbperez.bluestorm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    public MediaSeekBar rain;
    public MediaSeekBar wind;
    public MediaSeekBar thunder;
    public ImageButton toggleButton;
    public boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rain = new MediaSeekBar(
                MediaPlayer.create(getApplicationContext(), R.raw.soothingrain),
                (SeekBar) findViewById(R.id.rainSeekBar));
        rain.initializeMediaPlayer();
        rain.initializeSeekBar();

        wind = new MediaSeekBar(
                MediaPlayer.create(getApplicationContext(), R.raw.wind),
                (SeekBar) findViewById(R.id.windSeekBar));
        wind.initializeMediaPlayer();
        wind.initializeSeekBar();

        thunder = new MediaSeekBar(
                MediaPlayer.create(getApplicationContext(), R.raw.thunderrumble),
                (SeekBar) findViewById(R.id.thunderSeekBar));
        thunder.initializeMediaPlayer();
        thunder.initializeSeekBar();

        toggleButton = (ImageButton)findViewById(R.id.playButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setToggleButtonImage();
                toggleAllSounds();
                isPlaying = !isPlaying;
            }
        });

        if (isPlaying) {
            toggleAllSounds();
        }
    }

    public void setToggleButtonImage() {
        if (isPlaying) {
            toggleButton.setImageResource(android.R.drawable.ic_lock_silent_mode);
        } else {
            toggleButton.setImageResource(android.R.drawable.ic_lock_silent_mode_off);
        }
    }

    public void toggleAllSounds() {
        rain.toggleSound();
        wind.toggleSound();
        thunder.toggleSound();
    }
}