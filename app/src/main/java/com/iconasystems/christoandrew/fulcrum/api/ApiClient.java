package com.iconasystems.christoandrew.fulcrum.api;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://api.lufthansa.com/v1/";
    private List<Interceptor> interceptors = new ArrayList<>();

    public Retrofit getClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(logging);
        for (Interceptor interceptor : this.interceptors)
            builder.addInterceptor(interceptor);

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

    }

    public void addInterceptor(Interceptor interceptor) {
        this.interceptors.add(interceptor);
    }

}
