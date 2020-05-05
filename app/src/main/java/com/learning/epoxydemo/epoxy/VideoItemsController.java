package com.learning.epoxydemo.epoxy;

import androidx.annotation.NonNull;

import com.airbnb.epoxy.Typed2EpoxyController;
import com.learning.epoxydemo.data.VideoItem;
import com.learning.serverdrivenuidemo.BuildConfig;
//import com.learning.epoxydemo.epoxy.VideoItemModel_;


import java.util.List;
import java.util.UUID;

public class VideoItemsController extends Typed2EpoxyController<List<VideoItem>, VideoItem> {


    @Override
    protected void buildModels(List<VideoItem> videos, VideoItem banner) {

        new BannerVideoModel_()
                .id(banner.getId())
                .imageUrl(banner.getUrl())
                .title(banner.getTitle())
                .addTo(this);

        for (VideoItem video : videos) {
            new VideoItemModel_()
                    .id(video.getId())
                    .imageUrl(video.getUrl())
                    .title(video.getTitle())
                     .addTo(this);
        }
        new BannerVideoModel_()
                .id(banner.getId()+"1")
                .imageUrl(banner.getUrl())
                .title(banner.getTitle())
                .addTo(this);


    }

    @Override
    protected void onExceptionSwallowed(@NonNull RuntimeException exception) {
        if(BuildConfig.DEBUG) {
            throw exception;
        } else {
            super.onExceptionSwallowed(exception);
        }
    }
}
