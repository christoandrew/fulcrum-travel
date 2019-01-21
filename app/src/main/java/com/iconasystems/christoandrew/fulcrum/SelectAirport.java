package com.iconasystems.christoandrew.fulcrum;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.iconasystems.christoandrew.fulcrum.adapters.AirportsAdapter;
import com.iconasystems.christoandrew.fulcrum.api.ApiClient;
import com.iconasystems.christoandrew.fulcrum.api.ApiService;
import com.iconasystems.christoandrew.fulcrum.api.response.AirportsResponse;
import com.iconasystems.christoandrew.fulcrum.models.Airport;
import com.iconasystems.christoandrew.fulcrum.network.AuthInterceptor;
import com.iconasystems.christoandrew.fulcrum.utils.SimpleItemDividerDecoration;
import com.iconasystems.christoandrew.fulcrum.viewmodel.AirportsViewModel;
import com.iconasystems.christoandrew.fulcrum.viewmodel.TokenViewModel;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectAirport extends AppCompatActivity {
    private AirportsViewModel airportsViewModel;
    private List<Airport> airportList;
    private ProgressBar loader;

    private static final String TAG = Home.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_airport);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        loader = findViewById(R.id.airport_loader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        RecyclerView mAirportsRecyclerView = findViewById(R.id.airports_list);
        mAirportsRecyclerView.setHasFixedSize(true);
        mAirportsRecyclerView.setLayoutManager(mLayoutManager);
        mAirportsRecyclerView.addItemDecoration(new SimpleItemDividerDecoration(this));

        loader.setVisibility(View.VISIBLE);
        mAirportsRecyclerView.setVisibility(View.INVISIBLE);

        airportsViewModel = ViewModelProviders.of(this).get(AirportsViewModel.class);
        TokenViewModel tokenViewModel = ViewModelProviders.of(this).get(TokenViewModel.class);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        AuthInterceptor authInterceptor = new AuthInterceptor(tokenViewModel.getToken().getToken());
        ApiClient client = new ApiClient();
        client.addInterceptor(authInterceptor);
        ApiService apiService = client.getClient(builder).create(ApiService.class);

        Call<AirportsResponse> airportListCall = apiService.getAirports();

        airportListCall.enqueue(new Callback<AirportsResponse>() {
            @Override
            public void onResponse(Call<AirportsResponse> call, Response<AirportsResponse> response) {
                loader.setVisibility(View.GONE);
                mAirportsRecyclerView.setVisibility(View.VISIBLE);
                if (response.body() != null) {
                    List<Airport> airports;
                    airports = response.body().getAirportResource()
                            .getAirports().getAirport();

                    for (Airport airport : airports) {
                        Log.d(TAG, "Airport Name " + airport.getNames().getName().get(0).get$());
                        airportsViewModel.insertAirport(airport);
                    }

                    AirportsAdapter airportsAdapter = new AirportsAdapter(airports, airport -> {
                        Intent intent = getIntent();
                        Gson gson = new Gson();
                        intent.putExtra("airport", gson.toJson(airport));
                        setResult(RESULT_OK, intent);
                        finish();
                    });
                    mAirportsRecyclerView.setAdapter(airportsAdapter);
                }
            }

            @Override
            public void onFailure(Call<AirportsResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
