package com.iconasystems.christoandrew.fulcrum.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Name;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Names;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Position;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "airports")
public class Airport implements Serializable {
    @PrimaryKey
    @NonNull
    @SerializedName("AirportCode")
    @Expose
    private String airportCode;
    @SerializedName("Position")
    @Expose
    private Position position;
    @SerializedName("CityCode")
    @Expose
    private String cityCode;
    @SerializedName("CountryCode")
    @Expose
    private String countryCode;
    @SerializedName("LocationType")
    @Expose
    private String locationType;
    @SerializedName("Names")
    @Expose
    private Names names;
    @SerializedName("utcOffset")
    @Expose
    private Integer utcOffset;
    @SerializedName("TimeZoneId")
    @Expose
    private String timeZoneId;
    private final static long serialVersionUID = 1460230444122054595L;
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public Airport() {
    }

    /**
     * @param position
     * @param names
     * @param locationType
     * @param airportCode
     * @param countryCode
     * @param cityCode
     * @param utcOffset
     * @param timeZoneId
     */
    public Airport(String airportCode, Position position, String cityCode, String countryCode, String locationType, List<Name> names, Integer utcOffset, String timeZoneId) {
        super();
        this.airportCode = airportCode;
        this.position = position;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.locationType = locationType;
        this.utcOffset = utcOffset;
        this.timeZoneId = timeZoneId;
    }

    @NonNull
    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(@NonNull String airportCode) {
        this.airportCode = airportCode;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public Names getNames() {
        return names;
    }

    public void setNames(Names names) {
        this.names = names;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("airportCode", airportCode)
                .append("position", position)
                .append("cityCode", cityCode)
                .append("countryCode", countryCode)
                .append("locationType", locationType)
                .append("utcOffset", utcOffset)
                .append("timeZoneId", timeZoneId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(position).append(locationType).append(airportCode)
                .append(countryCode).append(cityCode).append(utcOffset).append(timeZoneId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Airport) == false) {
            return false;
        }
        Airport rhs = ((Airport) other);
        return new EqualsBuilder().append(position, rhs.position).append(locationType, rhs.locationType).append(airportCode, rhs.airportCode).append(countryCode, rhs.countryCode).append(cityCode, rhs.cityCode).append(utcOffset, rhs.utcOffset).append(timeZoneId, rhs.timeZoneId).isEquals();
    }


}
