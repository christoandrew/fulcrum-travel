package com.iconasystems.christoandrew.fulcrum.api.response.airport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.models.Airport;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class SingleAirports implements Serializable
{

    @SerializedName("Airport")
    @Expose
    private Airport airport = null;
    private final static long serialVersionUID = -1401749778676940822L;

    /**
     * No args constructor for use in serialization
     *
     */
    public SingleAirports() {
    }

    /**
     *
     * @param airport
     */
    public SingleAirports(Airport airport) {
        super();
        this.airport = airport;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
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
        if ((other instanceof SingleAirports) == false) {
            return false;
        }
        SingleAirports rhs = ((SingleAirports) other);
        return new EqualsBuilder().append(airport, rhs.airport).isEquals();
    }

}
