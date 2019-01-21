package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Equipment implements Serializable
{

    @SerializedName("AircraftCode")
    @Expose
    private String aircraftCode;
    private final static long serialVersionUID = -3894104404839473656L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Equipment() {
    }

    /**
     *
     * @param aircraftCode
     */
    public Equipment(String aircraftCode) {
        super();
        this.aircraftCode = aircraftCode;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("aircraftCode", aircraftCode).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(aircraftCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Equipment) == false) {
            return false;
        }
        Equipment rhs = ((Equipment) other);
        return new EqualsBuilder().append(aircraftCode, rhs.aircraftCode).isEquals();
    }

}
