package com.iconasystems.christoandrew.fulcrum.data.converters;

import android.arch.persistence.room.TypeConverter;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Coordinate;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Name;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Names;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Position;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;

public class AirportTypeConverter {
    @TypeConverter
    public static String fromPosition(Position position) {
        return (String.format(Locale.US, "%f,%f", position.getCoordinate().getLatitude(),
                position.getCoordinate().getLongitude()));
    }

    @TypeConverter
    public static Position toPosition(String position) {
        String[] pieces = position.split(",");
        Position pos = new Position();
        Coordinate coordinate = new Coordinate();
        coordinate.setLatitude(Double.parseDouble(pieces[0]));
        coordinate.setLongitude(Double.parseDouble(pieces[1]));
        pos.setCoordinate(coordinate);

        return pos;
    }

    @TypeConverter
    public static String fromName(Name name) {
        Gson gson = new Gson();
        return gson.toJson(name);
    }

    @TypeConverter
    public static Name toName(String name) {
        Gson gson = new Gson();
        return gson.fromJson(name, Name.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @TypeConverter
    public static String fromNames(Names names) {
        Gson gson = new Gson();
        String json = gson.toJson(names);
        return json;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @TypeConverter
    public static Names toNames(String namesString) {
        Gson gson = new Gson();
       return gson.fromJson(namesString,Names.class);
    }

}
