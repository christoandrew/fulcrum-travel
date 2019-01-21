package com.iconasystems.christoandrew.fulcrum;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.iconasystems.christoandrew.fulcrum.api.ApiClient;
import com.iconasystems.christoandrew.fulcrum.api.ApiService;
import com.iconasystems.christoandrew.fulcrum.api.response.AuthResponse;
import com.iconasystems.christoandrew.fulcrum.viewmodel.AirportsViewModel;
import com.iconasystems.christoandrew.fulcrum.viewmodel.TokenViewModel;

import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.Duration;
import java.util.Locale;
import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends AppCompatActivity {
    private static final String TAG = Splash.class.getSimpleName();
    private TokenViewModel tokenViewModel;
    private AirportsViewModel airportsViewModel;
    private boolean isLoading = true;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_splash);
        tokenViewModel = ViewModelProviders.of(this).get(TokenViewModel.class);
        airportsViewModel = ViewModelProviders.of(this).get(AirportsViewModel.class);

        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        final ApiService apiService = new ApiClient().getClient(builder).create(ApiService.class);

        Period period = Period.parse("PT1H2M");
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("hh:mm a");

        Log.d("Current period", ""+dateTimeFormatter.print(localTime));


        if(tokenViewModel.getToken() == null){
            apiService.login("63fkmp5fspe9mywuj37pea5z",
                    "sUyRaeRfYF",
                    "client_credentials").enqueue(new Callback<AuthResponse>() {
                @Override
                public void onResponse(@NonNull Call<AuthResponse> call,
                                       @NonNull Response<AuthResponse> response) {
                    if (response.body() != null) {
                        tokenViewModel.insertToken(response.body().getToken());
                        startActivity(new Intent(getApplicationContext(), Home.class));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<AuthResponse> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            });
        }else{
            startActivity(new Intent(getApplicationContext(), Home.class));
        }


    }
}
