package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Stops implements Serializable
{

    @SerializedName("StopQuantity")
    @Expose
    private long stopQuantity;
    private final static long serialVersionUID = -736427188841690086L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Stops() {
    }

    /**
     *
     * @param stopQuantity
     */
    public Stops(long stopQuantity) {
        super();
        this.stopQuantity = stopQuantity;
    }

    public long getStopQuantity() {
        return stopQuantity;
    }

    public void setStopQuantity(long stopQuantity) {
        this.stopQuantity = stopQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("stopQuantity", stopQuantity).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(stopQuantity).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stops) == false) {
            return false;
        }
        Stops rhs = ((Stops) other);
        return new EqualsBuilder().append(stopQuantity, rhs.stopQuantity).isEquals();
    }

}
