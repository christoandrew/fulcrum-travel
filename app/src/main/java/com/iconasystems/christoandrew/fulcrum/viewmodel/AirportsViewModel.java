package com.iconasystems.christoandrew.fulcrum.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.iconasystems.christoandrew.fulcrum.models.Airport;
import com.iconasystems.christoandrew.fulcrum.repository.DataRepository;

import java.util.List;

public class AirportsViewModel extends AndroidViewModel {
    private DataRepository dataRepository;
    private List<Airport> airports;
    public AirportsViewModel(@NonNull Application application) {
        super(application);
        this.dataRepository = new DataRepository(application);
        this.airports = dataRepository.getAirports();
    }

    public List<Airport> getAirports() {
        return this.airports;
    }

    public void insertAirport(Airport airport){
        this.dataRepository.insertAirport(airport);
    }

    public void insertAirports(List<Airport> airports){
        for(Airport airport: airports)
            this.dataRepository.insertAirports(airport);
    }

    public String getAirportName(String languageCode, String airportCode){
        return this.dataRepository.getAirportName(languageCode,airportCode).get$();
    };

    public Airport getAirport(String airportCode){
        return this.dataRepository.getAirport(airportCode);
    }
}
