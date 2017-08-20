package com.zeeroapps.hackathonapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.zeeroapps.hackathonapp.R;

public class FullScreenVideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_full_screen_video);

        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.autism));
        SharedPreferences sp = getSharedPreferences(getString(R.string.my_sp), MODE_PRIVATE);
        String curLang = sp.getString(getString(R.string.my_sp_language), null);
        if (curLang != null){
            if (curLang.equals("ur")){
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.autism_ur));
            }else {
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.autism));
            }
        }
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                finish();
            }
        });
    }
}
