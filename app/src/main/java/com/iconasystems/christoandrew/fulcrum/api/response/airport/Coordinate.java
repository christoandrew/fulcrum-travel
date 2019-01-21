package com.iconasystems.christoandrew.fulcrum.api.response.airport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Coordinate implements Serializable
{

    @SerializedName("Latitude")
    @Expose
    private Double latitude;
    @SerializedName("Longitude")
    @Expose
    private Double longitude;
    private final static long serialVersionUID = 8842558252922101856L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Coordinate() {
    }

    /**
     *
     * @param longitude
     * @param latitude
     */
    public Coordinate(Double latitude, Double longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("latitude", latitude).append("longitude", longitude).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(longitude).append(latitude).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Coordinate) == false) {
            return false;
        }
        Coordinate rhs = ((Coordinate) other);
        return new EqualsBuilder().append(longitude, rhs.longitude).append(latitude, rhs.latitude).isEquals();
    }

}
