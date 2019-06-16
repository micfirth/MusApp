package com.example.musapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.jgabrielfreitas.core.BlurImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private BlurImageView blurImg;
    private CircleImageView album;
    private ImageButton play;
    private ImageButton stop;
    private MediaPlayer player;
    private int pauseMom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blurImg = (BlurImageView)findViewById(R.id.bgImg);
        blurImg.setBlur(5);

        album = (CircleImageView)findViewById(R.id.albimg);
        play = (ImageButton)findViewById(R.id.playBtn);
        stop = (ImageButton)findViewById(R.id.stopBtn);
    }


    public void onClickBtn(View v){
        switch(v.getId()){
            case R.id.playBtn:
                if(player == null) {
                    player = MediaPlayer.create(getApplicationContext(), R.raw.wdyca);
                    player.start();
                    play.setImageResource(R.drawable.android_pause);
                }else if(player.isPlaying()){
                    player.pause();
                    pauseMom = player.getCurrentPosition();
                    play.setImageResource(R.drawable.android_play);
                }else if(!player.isPlaying()){
                    player.seekTo(pauseMom);
                    player.start();
                    play.setImageResource(R.drawable.android_pause);
                } break;

            case R.id.stopBtn:
                if(player != null) {
                    player.stop();
                    player = null;
                    play.setImageResource(R.drawable.android_play);
                } break;
        }
    }
}
