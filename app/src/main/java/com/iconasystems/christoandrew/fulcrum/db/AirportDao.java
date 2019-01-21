package com.iconasystems.christoandrew.fulcrum.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.iconasystems.christoandrew.fulcrum.models.Airport;

import java.util.List;

@Dao
public interface AirportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Airport airport);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Airport> airports);

    @Delete
    void delete(Airport airport);

    @Query("DELETE FROM airports WHERE airportCode=:airportCode")
    void deleteId(String airportCode);

    @Query("SELECT * FROM airports")
    List<Airport> getAirports();

    @Update
    void update(Airport airport);

    @Query("DELETE FROM airports")
    void deleteAll();

    @Query("SELECT * FROM airports WHERE airportCode=:airportCode")
    Airport getAirport(String airportCode);
}
