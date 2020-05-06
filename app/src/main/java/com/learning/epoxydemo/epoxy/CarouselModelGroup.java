package com.learning.epoxydemo.epoxy;

import android.util.Log;

import com.airbnb.epoxy.Carousel;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;
import com.learning.data.HomeScreenResponse;
import com.learning.serverdrivenuidemo.R;

import java.util.ArrayList;
import java.util.List;

public class CarouselModelGroup extends EpoxyModelGroup {
    private static int sectionId = 10000;

    private static final String TAG = "SERVER-DRIVEN-UI";


    public CarouselModelGroup(HomeScreenResponse.Item sectionData) {
        super(R.layout.layout_section, buildModels(sectionData));
        id(sectionId);
        sectionId++;
    }

    private static List<EpoxyModel<?>> buildModels(HomeScreenResponse.Item sectionData) {
        List<HomeScreenResponse.Item.SubItem> itemList =  sectionData.getData();
        ArrayList<EpoxyModel<?>> sectionModels = new ArrayList<>();


        if (itemList!= null && itemList.size() > 0) {
            HomeScreenResponse.SubItemViewType viewType = itemList.get(0).getViewType();
            Log.i(TAG, " items size " + itemList.size()  + " viewtype " + viewType  );

            if (viewType == HomeScreenResponse.SubItemViewType.Carousel) {
                Log.i(TAG, " viewtype  compare two" + viewType  );

                List<BannerVideoModel_> itemModels = new ArrayList<>();

                for (HomeScreenResponse.Item.SubItem item: itemList) {
                    itemModels.add( new BannerVideoModel_()
                            .id(item.getId())
                            .imageUrl(item.getImageUrl())
                            .title(item.getTitle()));
                }
                sectionModels.add(new CarouselModelModel_()
                        .id("carousel" + sectionId)
                        .padding(Carousel.Padding.dp(5, 4, 5, 16, 8))
                        .models(itemModels));


            }else if (viewType == HomeScreenResponse.SubItemViewType.Card) {
                List<CardModel_> itemModels = new ArrayList<>();

                for (HomeScreenResponse.Item.SubItem item: itemList) {
                    itemModels.add( new CardModel_()
                            .id(item.getId())
                            .imageUrl(item.getImageUrl())
                            .title(item.getTitle()));
                }
                sectionModels.add(new CarouselModelModel_()
                        .id("card " + sectionId)
                        .padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
                        .models(itemModels));
            }
        }
        return sectionModels;
    }
}
