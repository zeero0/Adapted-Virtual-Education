package com.zeeroapps.hackathonapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zeeroapps.hackathonapp.models.ModelVideos;
import com.zeeroapps.hackathonapp.R;
import com.zeeroapps.hackathonapp.activities.VideoDetailsActivity;

import java.util.ArrayList;

/**
 * Created by fazalullah on 4/17/17.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    String TAG = "MyApp";
    public Context mContext;
    ArrayList<ModelVideos> videosList;
    OnVideoChangeListner videoChangeListner;

    public VideoAdapter(Context c, ArrayList<ModelVideos> videos, OnVideoChangeListner vListner) {
        mContext = c;
        videosList = videos;
        videoChangeListner = vListner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_list, parent, false);
        ViewHolder vh = new ViewHolder(mContext, v, videosList, videoChangeListner);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ModelVideos mc = videosList.get(position);
        holder.bindData(mc);
    }


    @Override
    public int getItemCount() {
        return videosList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        static String TAG = "MyApp";
        public static Context mContext;
        public ArrayList<ModelVideos> mVideosList;
        private TextView tvVideoName;
        private TextView tvVideoDur;

        public ViewHolder(Context c, View v, ArrayList<ModelVideos> vidList, final OnVideoChangeListner videoListner) {
            super(v);
            mContext = c;
            mVideosList = vidList;
            tvVideoName = (TextView) v.findViewById(R.id.tvVideoName);
            tvVideoDur = (TextView) v.findViewById(R.id.tvVideoDur);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e(TAG, "Clicked Position: " + getAdapterPosition());
                    ModelVideos complaint = mVideosList.get(getAdapterPosition());
                    Intent intent = new Intent(mContext, VideoDetailsActivity.class);
                    intent.putExtra("video_name", complaint.getVideoName());
                    intent.putExtra("video_dur", complaint.getVideoDur());
                    intent.putExtra("video_descr", complaint.getVideoDescr());
                    mContext.startActivity(intent);
                }
            });
        }

        public void bindData(ModelVideos v) {
            tvVideoName.setText(v.getVideoName());
            tvVideoDur.setText(v.getVideoDur());
        }
    }

    public interface OnVideoChangeListner {
        void changeVideo(int i);

    }
}
