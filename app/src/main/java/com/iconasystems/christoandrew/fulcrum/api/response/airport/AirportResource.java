package com.iconasystems.christoandrew.fulcrum.api.response.airport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class AirportResource implements Serializable
{

    @SerializedName("Airports")
    @Expose
    private Airports airports;
    @SerializedName("Meta")
    @Expose
    private Meta meta;
    private final static long serialVersionUID = 8018113929050896510L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AirportResource() {
    }

    /**
     *
     * @param airports
     * @param meta
     */
    public AirportResource(Airports airports, Meta meta) {
        super();
        this.airports = airports;
        this.meta = meta;
    }

    public Airports getAirports() {
        return airports;
    }

    public void setAirports(Airports airports) {
        this.airports = airports;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("airports", airports).append("meta", meta).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(airports).append(meta).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AirportResource) == false) {
            return false;
        }
        AirportResource rhs = ((AirportResource) other);
        return new EqualsBuilder().append(airports, rhs.airports).append(meta, rhs.meta).isEquals();
    }

}
