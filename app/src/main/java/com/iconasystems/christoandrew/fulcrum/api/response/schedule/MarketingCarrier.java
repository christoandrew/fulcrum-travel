package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class MarketingCarrier implements Serializable
{

    @SerializedName("AirlineID")
    @Expose
    private String airlineID;
    @SerializedName("FlightNumber")
    @Expose
    private long flightNumber;
    private final static long serialVersionUID = 7895737798998456585L;

    /**
     * No args constructor for use in serialization
     *
     */
    public MarketingCarrier() {
    }

    /**
     *
     * @param airlineID
     * @param flightNumber
     */
    public MarketingCarrier(String airlineID, long flightNumber) {
        super();
        this.airlineID = airlineID;
        this.flightNumber = flightNumber;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(long flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("airlineID", airlineID).append("flightNumber", flightNumber).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(airlineID).append(flightNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MarketingCarrier) == false) {
            return false;
        }
        MarketingCarrier rhs = ((MarketingCarrier) other);
        return new EqualsBuilder().append(airlineID, rhs.airlineID).append(flightNumber, rhs.flightNumber).isEquals();
    }

}
