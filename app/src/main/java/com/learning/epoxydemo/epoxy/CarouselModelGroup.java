package com.learning.epoxydemo.epoxy;

import com.airbnb.epoxy.Carousel;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;
import com.learning.epoxydemo.data.CarouselData;
import com.learning.epoxydemo.data.VideoItem;
import com.learning.serverdrivenuidemo.R;

import java.util.ArrayList;
import java.util.List;

public class CarouselModelGroup extends EpoxyModelGroup {
    private static int itemId = 10;
    private static int sectionId = 10000;

    public CarouselModelGroup(CarouselData carouselData) {
        super(R.layout.layout_carousel, buildModels(carouselData));
        id(sectionId);
        sectionId++;
    }

    private static List<EpoxyModel<?>> buildModels(CarouselData carouselData) {
       List<VideoItem> itemList =  carouselData.getCarousalData();
        ArrayList<EpoxyModel<?>> carouselModels = new ArrayList<>();

        List<BannerVideoModel_> itemModels = new ArrayList<>();

        for (VideoItem video: itemList) {
            itemModels.add( new BannerVideoModel_()
                    .id(video.getId() + itemId)
                    .imageUrl(video.getUrl())
                    .title(video.getTitle()));
            itemId++;
        }
        carouselModels.add(new CarouselModelModel_()
        .id("carousel" + sectionId)
                .padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
                .models(itemModels));

        return carouselModels;
    }
}
