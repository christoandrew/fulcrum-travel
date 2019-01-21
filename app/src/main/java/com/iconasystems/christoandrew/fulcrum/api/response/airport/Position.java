package com.iconasystems.christoandrew.fulcrum.api.response.airport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Position implements Serializable
{

    @SerializedName("Coordinate")
    @Expose
    private Coordinate coordinate;
    private final static long serialVersionUID = -6910803898787295857L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Position() {
    }

    /**
     *
     * @param coordinate
     */
    public Position(Coordinate coordinate) {
        super();
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("coordinate", coordinate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(coordinate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Position) == false) {
            return false;
        }
        Position rhs = ((Position) other);
        return new EqualsBuilder().append(coordinate, rhs.coordinate).isEquals();
    }

}
