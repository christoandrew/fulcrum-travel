package com.iconasystems.christoandrew.fulcrum.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import com.iconasystems.christoandrew.fulcrum.api.response.airport.Name;
import com.iconasystems.christoandrew.fulcrum.data.converters.AirportTypeConverter;
import com.iconasystems.christoandrew.fulcrum.models.Airport;
import com.iconasystems.christoandrew.fulcrum.models.Token;

@Database(entities = {Airport.class, Token.class, Name.class}, version = 8)
@TypeConverters(AirportTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract AirportDao placeDao();

    public abstract TokenDao tokenDao();

    public abstract NameDao nameDao();
}
