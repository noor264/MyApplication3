package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class testSound extends AppCompatActivity {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sound);
    }

    public void play(View view){
        if (player==null)
        {
            player=MediaPlayer.create(this, R.raw.test1);
        }
        player.start();
    }
}