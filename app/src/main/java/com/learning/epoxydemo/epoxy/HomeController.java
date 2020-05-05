package com.learning.epoxydemo.epoxy;

import com.airbnb.epoxy.AutoModel;
import com.airbnb.epoxy.TypedEpoxyController;
import com.learning.epoxydemo.data.CarouselData;

import java.util.List;

public class HomeController  extends TypedEpoxyController<List<CarouselData>> {

    @AutoModel
    HeaderItemModel_ header;


    @Override
    protected void buildModels(List<CarouselData> carousels) {

       header.title("Recommended");
        for (int i = 0; i < carousels.size(); i++) {
            CarouselData carousel = carousels.get(i);
            add(new CarouselModelGroup(carousel));
        }

    }
}
