package com.learning.epoxydemo.data;

import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class SampleDataSource {

    public static VideoItem fetchBannerVideo(){

        return new VideoItem(  "9kRgVxULbag","https://i.ytimg.com/vi/9kRgVxULbag/hqdefault.jpg","Firebase - Ultimate Beginner&#39;s Guide");
    }

    public static List<VideoItem> fetchVideoItems() {
        List<VideoItem> list = new ArrayList<>();
        for ( int i = 0; i < 10; i++) {
            list.add( new VideoItem(  "BXHQ5NxU2p8","https://i.ytimg.com/vi/BXHQ5NxU2p8/hqdefault.jpg","What is Firebase ?"));
        }
        return list;
    }
}
