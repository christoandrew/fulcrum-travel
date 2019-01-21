package com.iconasystems.christoandrew.fulcrum.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.SingleAirportResource;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class AirportResponse implements Serializable
{

    @SerializedName("AirportResource")
    @Expose
    private SingleAirportResource airportResource;
    private final static long serialVersionUID = -3695799916435870504L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AirportResponse() {
    }

    /**
     *
     * @param airportResource
     */
    public AirportResponse(SingleAirportResource airportResource) {
        super();
        this.airportResource = airportResource;
    }

    public SingleAirportResource getSingleAirportResource() {
        return airportResource;
    }

    public void setSingleAirportResource(SingleAirportResource airportResource) {
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
        if (!(other instanceof AirportResponse)) {
            return false;
        }
        AirportResponse rhs = ((AirportResponse) other);
        return new EqualsBuilder().append(airportResource, rhs.airportResource).isEquals();
    }

}


