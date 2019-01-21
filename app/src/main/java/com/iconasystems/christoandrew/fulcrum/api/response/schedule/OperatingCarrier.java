package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class OperatingCarrier implements Serializable
{

    @SerializedName("AirlineID")
    @Expose
    private String airlineID;
    private final static long serialVersionUID = -724418203486822187L;

    /**
     * No args constructor for use in serialization
     *
     */
    public OperatingCarrier() {
    }

    /**
     *
     * @param airlineID
     */
    public OperatingCarrier(String airlineID) {
        super();
        this.airlineID = airlineID;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("airlineID", airlineID).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(airlineID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OperatingCarrier) == false) {
            return false;
        }
        OperatingCarrier rhs = ((OperatingCarrier) other);
        return new EqualsBuilder().append(airlineID, rhs.airlineID).isEquals();
    }

}
