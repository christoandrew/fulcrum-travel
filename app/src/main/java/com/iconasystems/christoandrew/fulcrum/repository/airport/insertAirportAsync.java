package com.iconasystems.christoandrew.fulcrum.repository.airport;

import android.os.AsyncTask;

import com.iconasystems.christoandrew.fulcrum.api.response.airport.Name;
import com.iconasystems.christoandrew.fulcrum.db.AirportDao;
import com.iconasystems.christoandrew.fulcrum.db.NameDao;
import com.iconasystems.christoandrew.fulcrum.models.Airport;

public class insertAirportAsync extends AsyncTask<Airport, Void, Void> {
    private AirportDao asyncTaskDao;
    private NameDao nameDao;

    public insertAirportAsync(AirportDao airportDao, NameDao nameDao) {
        this.asyncTaskDao = airportDao;
        this.nameDao = nameDao;
    }

    @Override
    protected Void doInBackground(Airport... airports) {
        Airport airport = airports[0];
        this.asyncTaskDao.insert(airport);

        for(Name name: airport.getNames().getName()){
            name.setAirportCode(airport.getAirportCode());
            this.nameDao.insert(name);
        }

        return null;
    }
}
