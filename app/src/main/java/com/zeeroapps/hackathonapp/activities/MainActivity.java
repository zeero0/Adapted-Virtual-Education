package com.zeeroapps.hackathonapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zeeroapps.hackathonapp.models.ModelVideos;
import com.zeeroapps.hackathonapp.R;
import com.zeeroapps.hackathonapp.adapters.VideoAdapter;
import com.zeeroapps.hackathonapp.utils.LanguageSettings;

import java.util.ArrayList;

public class MainActivity extends Activity implements VideoAdapter.OnVideoChangeListner {

    ImageView ivVideoThumb;
    TextView tvVideoName, tvVideoDur;
    TextView tvDescr;
    RecyclerView recyclerView;
    VideoAdapter videoAdapter;
    private RelativeLayout layoutMain;
    private ArrayList<ModelVideos> videosList;
    private VideoAdapter customAdapter;

    String videoURL;
    String[] videoNames = {"VIDEO 1", "VIDEO 2", "VIDEO 3", "VIDEO 4", "VIDEO 5"};
    String[] videoDurations = {"4:24", "5:11", "9:00", "3:42", "7:30"};
    String[] videosDescr = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "laboris nisi ut aliquip ex ea commodo consequat.",
            "sunt in culpa qui officia deserunt mollit anim id est laborum. Ut enim ad minim veniam, quis nostrud exercitation ullamco "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivVideoThumb = (ImageView) findViewById(R.id.imageView);
        tvDescr = (TextView) findViewById(R.id.tvSelectedVideoDescr);
        tvVideoName = (TextView) findViewById(R.id.tvSelectedVideoName);
        tvVideoDur = (TextView) findViewById(R.id.tvSelectedVideoDur);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutMain = (RelativeLayout) findViewById(R.id.main_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        videosList = new ArrayList<ModelVideos>();
        customAdapter = new VideoAdapter(this, videosList, this);
        recyclerView.setAdapter(customAdapter);

        setRecyclerView();
    }

    private void setRecyclerView() {
        ModelVideos mVideo;

        for (int i = 0; i<videoNames.length; i++){
            mVideo = new ModelVideos();
            mVideo.setVideoName(videoNames[i]);
            mVideo.setVideoDur(videoDurations[i]);
            mVideo.setVideoDescr(videosDescr[i]);
            videosList.add(mVideo);
        }

        customAdapter.notifyDataSetChanged();
    }

    public void onClickThumbnail(View v){
        Intent intent = new Intent(MainActivity.this, FullScreenVideoActivity.class);
        intent.putExtra("video_url", videoURL);
        startActivity(intent);
    }

    public void onClickLanguageButton(View v){
        LanguageSettings.changeLanguage(this, "ur");
        this.recreate();
    }

    @Override
    public void changeVideo(int i) {
        tvVideoName.setText(videoNames[i]);
        tvVideoDur.setText(videoDurations[i]);
    }
}
