package com.learning.serverdrivenuidemo;

import android.app.Application;

import com.airbnb.epoxy.Carousel;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       // Carousel.setDefaultGlobalSnapHelperFactory(null);

    }
}
