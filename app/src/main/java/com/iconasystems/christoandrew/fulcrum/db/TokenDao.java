package com.iconasystems.christoandrew.fulcrum.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.iconasystems.christoandrew.fulcrum.models.Token;

@Dao
public interface TokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Token token);
    @Query("SELECT * FROM tokens LIMIT 1")
    Token getToken();

    @Query("DELETE FROM tokens")
    void deleteAll();
}
