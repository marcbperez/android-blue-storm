package com.marcbperez.marcbperez.bluestorm;

import android.media.MediaPlayer;
import android.widget.SeekBar;

public class MediaSeekBar {

    public MediaPlayer mediaPlayer;
    public SeekBar seekBar;
    public int maxVolume = 100;

    public MediaSeekBar(MediaPlayer mediaPlayer, SeekBar seekBar) {
        this.mediaPlayer = mediaPlayer;
        this.seekBar = seekBar;
    }

    public MediaPlayer initializeMediaPlayer() {
        mediaPlayer.setLooping(true);

        return mediaPlayer;
    }

    public void setVolume(int newVolume) {
        float volume = (float) (1 - (Math.log(maxVolume - newVolume) / Math.log(maxVolume)));
        mediaPlayer.setVolume(volume, volume);
    }

    public void toggleSound() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    public SeekBar initializeSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setVolume(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBar.setProgress(maxVolume);

        return seekBar;
    }
}
