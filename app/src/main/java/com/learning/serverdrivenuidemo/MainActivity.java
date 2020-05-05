package com.learning.serverdrivenuidemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.learning.epoxydemo.data.Data;
import com.learning.epoxydemo.data.SampleDataSource;
import com.learning.epoxydemo.epoxy.HomeController;
import com.learning.epoxydemo.epoxy.VideoItemsController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.videos_recylerView)
    EpoxyRecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // setupEpoxyUI();
        setupHomeUI();
    }

    private  void setupHomeUI(){
        HomeController controller = new HomeController();
        recyclerView.setAdapter(controller.getAdapter());
        recyclerView.setHasFixedSize(true);
        controller.setData(Data.INSTANCE.getHomeResponse());
    }

    private  void setupEpoxyUI(){
        VideoItemsController controller = new VideoItemsController();
        recyclerView.setAdapter(controller.getAdapter());
        recyclerView.setHasFixedSize(true);
        controller.setData(SampleDataSource.fetchVideoItems(), SampleDataSource.fetchBannerVideo());
    }

}
