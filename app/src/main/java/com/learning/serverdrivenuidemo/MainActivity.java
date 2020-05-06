package com.learning.serverdrivenuidemo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.epoxy.EpoxyRecyclerView;
import com.learning.data.APIService;
import com.learning.data.HomeScreenResponse;
import com.learning.epoxydemo.epoxy.HomeController;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SERVER-DRIVEN-UI";

    @BindView(R.id.videos_recylerView)
    EpoxyRecyclerView recyclerView;

    HomeController controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
         controller = new HomeController();
        recyclerView.setAdapter(controller.getAdapter());
        recyclerView.setHasFixedSize(true);
        fetchData();
    }

    private void fetchData(){
        APIService.Creator.newRestService().getHomeScreenData().enqueue(new Callback<HomeScreenResponse>() {
            @Override
            public void onResponse(Call<HomeScreenResponse> call, Response<HomeScreenResponse> response) {
                Log.i(TAG, "fetch data response code " + response.code());
                Log.i(TAG, "fetch data issuccess " + response.isSuccessful());
                HomeScreenResponse homeScreenResponse = response.body();
                if(homeScreenResponse!=null) {
                    Log.i(TAG, "fetch data data " + homeScreenResponse.getData().size());
                    controller.setData(homeScreenResponse.getData());
                }

            }

            @Override
            public void onFailure(Call<HomeScreenResponse> call, Throwable t) {
                Log.e(TAG, "failed " + t.getLocalizedMessage());

            }
        });
    }

}
