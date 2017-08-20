package com.zeeroapps.hackathonapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeeroapps.hackathonapp.R;

public class VideoDetailsActivity extends AppCompatActivity {

    ImageView ivThumb;
    TextView tvVideoName, tvVideoDur, tvVideoDescr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);

        ivThumb = (ImageView) findViewById(R.id.imageView);
        tvVideoDescr = (TextView) findViewById(R.id.tvSelectedVideoDescr);
        tvVideoName = (TextView) findViewById(R.id.tvSelectedVideoName);
        tvVideoDur = (TextView) findViewById(R.id.tvSelectedVideoDur);

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            tvVideoName.setText(intent.getStringExtra("video_name"));
            tvVideoDur.setText(intent.getStringExtra("video_dur"));
            tvVideoDescr.setText(intent.getStringExtra("video_descr"));
        }

    }
}
