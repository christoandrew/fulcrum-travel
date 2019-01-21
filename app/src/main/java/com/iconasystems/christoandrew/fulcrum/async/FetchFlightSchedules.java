package com.iconasystems.christoandrew.fulcrum.async;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.iconasystems.christoandrew.fulcrum.api.ApiService;
import com.iconasystems.christoandrew.fulcrum.api.response.FlightScheduleResponse;
import com.iconasystems.christoandrew.fulcrum.models.Schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FetchFlightSchedules extends AsyncTask<Void, Void, List<Schedule>> {
    private ApiService apiService;
    private List<Schedule> schedule;
    private String origin;
    private String destination;



    public FetchFlightSchedules(ApiService apiService, String origin, String destination) {
        this.apiService = apiService;
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    protected List<Schedule> doInBackground(Void... voids) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        apiService.getScheduledFlights(origin, destination,format.format( new Date())).enqueue(
                new Callback<FlightScheduleResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<FlightScheduleResponse> call,
                                           @NonNull Response<FlightScheduleResponse> response) {
                        if (response.body() != null) {
                            if(response.body().getScheduleResource() != null)
                                schedule = response.body().getScheduleResource().getSchedule();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<FlightScheduleResponse> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                }
        );
        return schedule;
    };
}
