package com.iconasystems.christoandrew.fulcrum.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.api.response.schedule.Flight;
import com.iconasystems.christoandrew.fulcrum.api.response.schedule.TotalJourney;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Schedule implements Serializable
{

    @SerializedName("TotalJourney")
    @Expose
    private TotalJourney totalJourney;
    @SerializedName("Flight")
    @Expose
    private List<Flight> flight;
    private final static long serialVersionUID = 727032519359851411L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Schedule() {
    }

    /**
     *
     * @param flight
     * @param totalJourney
     */
    public Schedule(TotalJourney totalJourney, List<Flight> flight) {
        super();
        this.totalJourney = totalJourney;
        this.flight = flight;
    }

    public TotalJourney getTotalJourney() {
        return totalJourney;
    }

    public void setTotalJourney(TotalJourney totalJourney) {
        this.totalJourney = totalJourney;
    }

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("totalJourney", totalJourney).append("flight", flight).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(flight).append(totalJourney).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Schedule) == false) {
            return false;
        }
        Schedule rhs = ((Schedule) other);
        return new EqualsBuilder().append(flight, rhs.flight).append(totalJourney, rhs.totalJourney).isEquals();
    }

}
