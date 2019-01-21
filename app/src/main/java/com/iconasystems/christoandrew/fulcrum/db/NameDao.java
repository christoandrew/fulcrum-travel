package com.iconasystems.christoandrew.fulcrum.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.iconasystems.christoandrew.fulcrum.api.response.airport.Name;

@Dao
public interface NameDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Name name);

    @Query("SELECT * FROM names WHERE languageCode=:languageCode AND airportCode=:airportCode")
    public Name getName(String languageCode, String airportCode);

}
