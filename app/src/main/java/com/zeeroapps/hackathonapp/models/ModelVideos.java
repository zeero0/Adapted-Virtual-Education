package com.zeeroapps.hackathonapp.models;

/**
 * Created by fazalullah on 8/20/17.
 */

public class ModelVideos {
    private String videoName;
    private String videoDur;
    private String videoDescr;

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public void setVideoDur(String videoDur) {
        this.videoDur = videoDur;
    }

    public String getVideoName() {
        return videoName;
    }

    public String getVideoDur() {
        return videoDur;
    }

    public void setVideoDescr(String videoDescr) {
        this.videoDescr = videoDescr;
    }

    public String getVideoDescr() {
        return videoDescr;
    }
}
