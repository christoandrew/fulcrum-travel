package com.iconasystems.christoandrew.fulcrum.api.response.airport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.models.Airport;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Airports implements Serializable
{

    @SerializedName("Airport")
    @Expose
    private List<Airport> airport = null;
    private final static long serialVersionUID = -1401749778676940822L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Airports() {
    }

    /**
     *
     * @param airport
     */
    public Airports(List<Airport> airport) {
        super();
        this.airport = airport;
    }

    public List<Airport> getAirport() {
        return airport;
    }

    public void setAirport(List<Airport> airport) {
        this.airport = airport;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("airport", airport).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(airport).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Airports) == false) {
            return false;
        }
        Airports rhs = ((Airports) other);
        return new EqualsBuilder().append(airport, rhs.airport).isEquals();
    }

}
