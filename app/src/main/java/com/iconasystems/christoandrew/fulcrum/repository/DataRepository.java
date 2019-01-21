package com.iconasystems.christoandrew.fulcrum.repository;

import android.app.Application;

import com.iconasystems.christoandrew.fulcrum.api.response.airport.Name;
import com.iconasystems.christoandrew.fulcrum.db.AirportDao;
import com.iconasystems.christoandrew.fulcrum.db.AppDatabase;
import com.iconasystems.christoandrew.fulcrum.db.NameDao;
import com.iconasystems.christoandrew.fulcrum.db.TokenDao;
import com.iconasystems.christoandrew.fulcrum.models.Airport;
import com.iconasystems.christoandrew.fulcrum.models.Token;
import com.iconasystems.christoandrew.fulcrum.repository.airport.insertAirportAsync;
import com.iconasystems.christoandrew.fulcrum.repository.airport.insertAirportsAsync;
import com.iconasystems.christoandrew.fulcrum.repository.auth.insertTokenAsync;

import java.util.List;

public class DataRepository {
    private AirportDao airportDao;
    private TokenDao tokenDao;
    private NameDao nameDao;
    private Token token;
    private List<Airport> airports;

    public DataRepository(Application application) {
        AppDatabase database = AppDatabase.getDatabase(application);
        airportDao = database.placeDao();
        tokenDao = database.tokenDao();
        this.nameDao = database.nameDao();
        airports = airportDao.getAirports();
        token = tokenDao.getToken();
    }

    public List<Airport> getAirports(){
        return this.airports;
    }
    
    public void insertAirport(Airport... airport){
        new insertAirportAsync(airportDao,nameDao).execute(airport);
    }

    public void insertAirports(Airport airport){
        new insertAirportsAsync(airportDao, nameDao).execute(airport);
    }

    public void insertToken(String token){
        new insertTokenAsync(tokenDao).execute(token);
    }

    public Token getToken() {
        return this.token;
    }

    public Name getAirportName(String languageCode, String airportCode){
        return this.nameDao.getName(languageCode, airportCode);
    }

    public Airport getAirport(String airportCode) {
        return this.airportDao.getAirport(airportCode);
    }
}
