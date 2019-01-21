package com.iconasystems.christoandrew.fulcrum;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iconasystems.christoandrew.fulcrum.R;
import com.iconasystems.christoandrew.fulcrum.adapters.ScheduleAdapter;
import com.iconasystems.christoandrew.fulcrum.api.ApiClient;
import com.iconasystems.christoandrew.fulcrum.api.ApiService;
import com.iconasystems.christoandrew.fulcrum.api.response.FlightScheduleResponse;
import com.iconasystems.christoandrew.fulcrum.async.FetchFlightSchedules;
import com.iconasystems.christoandrew.fulcrum.models.Schedule;
import com.iconasystems.christoandrew.fulcrum.network.AuthInterceptor;
import com.iconasystems.christoandrew.fulcrum.utils.SimpleItemDividerDecoration;
import com.iconasystems.christoandrew.fulcrum.viewmodel.TokenViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlightSchedules extends AppCompatActivity {
    private static final String TAG = FlightSchedules.class.getSimpleName();
    private RecyclerView mFlightsSchedules;
    private ProgressBar mLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_schedules);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mFlightsSchedules = findViewById(R.id.schedule_list);
        mFlightsSchedules.setHasFixedSize(true);
        mFlightsSchedules.setLayoutManager(mLayoutManager);
        mFlightsSchedules.addItemDecoration(new SimpleItemDividerDecoration(this));

        mLoader = findViewById(R.id.flight_loader);
        mLoader.setVisibility(View.VISIBLE);
        mFlightsSchedules.setVisibility(View.GONE);

        Intent intent = getIntent();
        String origin = intent.getStringExtra("origin");
        String destination = intent.getStringExtra("destination");
        TokenViewModel tokenViewModel = ViewModelProviders.of(this).get(TokenViewModel.class);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        AuthInterceptor authInterceptor = new AuthInterceptor(tokenViewModel.getToken().getToken());
        ApiClient client = new ApiClient();
        client.addInterceptor(authInterceptor);
        ApiService apiService = client.getClient(builder).create(ApiService.class);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        apiService.getScheduledFlights(origin, destination, format.format(new Date())).enqueue(

                new Callback<FlightScheduleResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<FlightScheduleResponse> call,
                                           @NonNull Response<FlightScheduleResponse> response) {
                        List<Schedule> scheduleList = new ArrayList<>();
                        mLoader.setVisibility(View.GONE);
                        mFlightsSchedules.setVisibility(View.VISIBLE);
                        if (response.body() != null) {
                            if (response.body().getScheduleResource() != null)
                                scheduleList = response.body().getScheduleResource().getSchedule();
                            mFlightsSchedules.setAdapter(new ScheduleAdapter(scheduleList, schedule -> {
                                Intent intent1 = new Intent(getApplicationContext(), Flights.class);
                                intent1.putExtra("flights", new Gson().toJson(schedule.getFlight()));
                                startActivity(intent1);
                            }));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<FlightScheduleResponse> call, @NonNull Throwable t) {
                        Intent intent = getIntent();
                        finish();
                        t.printStackTrace();
                    }
                }
        );

    }

}
