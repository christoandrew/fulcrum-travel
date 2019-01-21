package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Arrival implements Serializable
{

    @SerializedName("AirportCode")
    @Expose
    private String airportCode;
    @SerializedName("ScheduledTimeLocal")
    @Expose
    private ScheduledTimeLocal_ scheduledTimeLocal;
    @SerializedName("Terminal")
    @Expose
    private Terminal terminal;
    private final static long serialVersionUID = 6508346444059344179L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Arrival() {
    }

    /**
     *
     * @param terminal
     * @param airportCode
     * @param scheduledTimeLocal
     */
    public Arrival(String airportCode, ScheduledTimeLocal_ scheduledTimeLocal, Terminal terminal) {
        super();
        this.airportCode = airportCode;
        this.scheduledTimeLocal = scheduledTimeLocal;
        this.terminal = terminal;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public ScheduledTimeLocal_ getScheduledTimeLocal() {
        return scheduledTimeLocal;
    }

    public void setScheduledTimeLocal(ScheduledTimeLocal_ scheduledTimeLocal) {
        this.scheduledTimeLocal = scheduledTimeLocal;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("airportCode", airportCode).append("scheduledTimeLocal", scheduledTimeLocal).append("terminal", terminal).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(terminal).append(airportCode).append(scheduledTimeLocal).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Arrival) == false) {
            return false;
        }
        Arrival rhs = ((Arrival) other);
        return new EqualsBuilder().append(terminal, rhs.terminal).append(airportCode, rhs.airportCode).append(scheduledTimeLocal, rhs.scheduledTimeLocal).isEquals();
    }

}
