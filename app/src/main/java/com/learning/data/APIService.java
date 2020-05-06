package com.learning.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIService {

     String ENDPOINT = "https://gist.githubusercontent.com/kiranbollepalli9/f2382028608f7b9d56b7fc4f6570e738/raw/273d952addf939a6dc3314020f9727538d03a14c/";

    @GET("server-driven-ui.json")
    Call<HomeScreenResponse> getHomeScreenData();

    class Creator {

        public static APIService newRestService() {
            Gson gson = new GsonBuilder().create();

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.addInterceptor(loggingInterceptor);

            builder.connectTimeout(2, TimeUnit.MINUTES);
            builder.readTimeout(2, TimeUnit.MINUTES);

            Retrofit retrofit = new Retrofit.Builder().baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(builder.build())
                    .build();

            return retrofit.create(APIService.class);
        }
    }

}
