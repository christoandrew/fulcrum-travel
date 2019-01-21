package com.iconasystems.christoandrew.fulcrum.repository.airport;

import android.os.AsyncTask;

import com.iconasystems.christoandrew.fulcrum.api.response.airport.Name;
import com.iconasystems.christoandrew.fulcrum.db.AirportDao;
import com.iconasystems.christoandrew.fulcrum.db.NameDao;
import com.iconasystems.christoandrew.fulcrum.models.Airport;

public class insertAirportsAsync extends AsyncTask<Airport, Void, Void> {
    private final AirportDao airportDao;
    private final NameDao nameDao;

    public insertAirportsAsync(AirportDao airportDao, NameDao nameDao) {
        this.airportDao = airportDao;
        this.nameDao = nameDao;
    }

    @Override
    protected final Void doInBackground(Airport... airports) {
        Airport airport = airports[0];
        airportDao.deleteAll();
        airportDao.insert(airport);
        for(Name name: airport.getNames().getName()){
            name.setAirportCode(airport.getAirportCode());
            this.nameDao.insert(name);
        }
        return null;
    }
}
