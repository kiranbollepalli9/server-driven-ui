package com.learning.epoxydemo.epoxy;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.airbnb.epoxy.Carousel;
import com.airbnb.epoxy.ModelView;

import org.jetbrains.annotations.NotNull;

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
public class CarouselModel extends Carousel {
    public CarouselModel(Context context) {
        super(context);
    }

    @NotNull
    @Override
    protected LayoutManager createLayoutManager() {
        return new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
    }
}
