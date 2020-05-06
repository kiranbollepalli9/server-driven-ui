package com.learning.epoxydemo.epoxy;

import android.util.Log;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.learning.data.HomeScreenResponse;

import java.util.List;

public class HomeController  extends TypedEpoxyController<List<HomeScreenResponse.Item>> {
    private static final String TAG = "SERVER-DRIVEN-UI";

    @AutoModel
    HeaderItemModel_ header;
    private static int itemId = 10;



    @Override
    protected void buildModels(List<HomeScreenResponse.Item> sectionDataList) {
        Log.i(TAG, " build models " + sectionDataList.size());
        for (int i = 0; i < sectionDataList.size(); i++) {

            HomeScreenResponse.Item section = sectionDataList.get(i);
            if(section.getHeader()!=null ) {
                add(new HeaderItemModel_()
                        .id(itemId)
                        .title(section.getHeader().getTitle())
                        .show(section.getData().size() > 0));
                itemId++;
            }

            add(new CarouselModelGroup(section));
        }

    }
}
