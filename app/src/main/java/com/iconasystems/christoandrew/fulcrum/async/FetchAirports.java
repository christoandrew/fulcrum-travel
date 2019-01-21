package com.iconasystems.christoandrew.fulcrum.async;

import android.os.AsyncTask;

import com.iconasystems.christoandrew.fulcrum.api.ApiService;
import com.iconasystems.christoandrew.fulcrum.api.response.AirportsResponse;
import com.iconasystems.christoandrew.fulcrum.models.Airport;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchAirports extends AsyncTask<Void, Void, List<Airport>> {
    private ApiService apiService;
    private List<Airport> airports = new ArrayList<>();

    public FetchAirports(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    protected List<Airport> doInBackground(Void... voids) {

        try {
            apiService.getAirports().enqueue(new Callback<AirportsResponse>() {
                @Override
                public void onResponse(Call<AirportsResponse> call, Response<AirportsResponse> response) {
                    if(response.body() != null){
                        airports = response.body().getAirportResource().getAirports().getAirport();
                    }
                }

                @Override
                public void onFailure(Call<AirportsResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });


        }catch (Exception ex){
            System.out.print("Error = "+ex.getMessage());
        }

        return airports;
    }

}