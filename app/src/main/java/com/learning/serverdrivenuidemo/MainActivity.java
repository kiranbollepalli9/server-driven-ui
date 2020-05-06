package com.learning.serverdrivenuidemo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.learning.data.APIService;
import com.learning.data.HomeScreenResponse;
import com.learning.epoxydemo.data.Data;
import com.learning.epoxydemo.data.SampleDataSource;
import com.learning.epoxydemo.epoxy.HomeController;
import com.learning.epoxydemo.epoxy.VideoItemsController;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.videos_recylerView)
    EpoxyRecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // setupEpoxyUI();
        //setupHomeUI();
        fetchData();
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

    private void fetchData(){
        APIService.Creator.newRestService().getHomeScreenData().enqueue(new Callback<HomeScreenResponse>() {
            @Override
            public void onResponse(Call<HomeScreenResponse> call, Response<HomeScreenResponse> response) {
                Log.i(TAG, "fetch data response code " + response.code());
                Log.i(TAG, "fetch data issuccess " + response.isSuccessful());
                HomeScreenResponse homeScreenResponse = response.body();
                if(homeScreenResponse!=null) {
                    homeScreenResponse.getData();
                }

            }

            @Override
            public void onFailure(Call<HomeScreenResponse> call, Throwable t) {
                Log.e(TAG, "failed " + t.getLocalizedMessage());

            }
        });
    }

}
