package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Departure implements Serializable
{

    @SerializedName("AirportCode")
    @Expose
    private String airportCode;
    @SerializedName("ScheduledTimeLocal")
    @Expose
    private ScheduledTimeLocal scheduledTimeLocal;
    private final static long serialVersionUID = 233567604435202808L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Departure() {
    }

    /**
     *
     * @param airportCode
     * @param scheduledTimeLocal
     */
    public Departure(String airportCode, ScheduledTimeLocal scheduledTimeLocal) {
        super();
        this.airportCode = airportCode;
        this.scheduledTimeLocal = scheduledTimeLocal;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public ScheduledTimeLocal getScheduledTimeLocal() {
        return scheduledTimeLocal;
    }

    public void setScheduledTimeLocal(ScheduledTimeLocal scheduledTimeLocal) {
        this.scheduledTimeLocal = scheduledTimeLocal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("airportCode", airportCode).append("scheduledTimeLocal", scheduledTimeLocal).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(airportCode).append(scheduledTimeLocal).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Departure) == false) {
            return false;
        }
        Departure rhs = ((Departure) other);
        return new EqualsBuilder().append(airportCode, rhs.airportCode).append(scheduledTimeLocal, rhs.scheduledTimeLocal).isEquals();
    }

}
