package com.iconasystems.christoandrew.fulcrum.api.response;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.AirportResource;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AirportsResponse implements Serializable
{

    @SerializedName("AirportResource")
    @Expose
    private AirportResource airportResource;
    private final static long serialVersionUID = -3695799916435870506L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AirportsResponse() {
    }

    /**
     *
     * @param airportResource
     */
    public AirportsResponse(AirportResource airportResource) {
        super();
        this.airportResource = airportResource;
    }

    public AirportResource getAirportResource() {
        return airportResource;
    }

    public void setAirportResource(AirportResource airportResource) {
        this.airportResource = airportResource;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("airportResource", airportResource).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(airportResource).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AirportsResponse)) {
            return false;
        }
        AirportsResponse rhs = ((AirportsResponse) other);
        return new EqualsBuilder().append(airportResource, rhs.airportResource).isEquals();
    }

}


