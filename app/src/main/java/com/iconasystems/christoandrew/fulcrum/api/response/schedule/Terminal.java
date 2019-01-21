package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Terminal implements Serializable
{

    @SerializedName("Name")
    @Expose
    private String name;
    private final static long serialVersionUID = 7487135725007508445L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Terminal() {
    }

    /**
     *
     * @param name
     */
    public Terminal(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Terminal) == false) {
            return false;
        }
        Terminal rhs = ((Terminal) other);
        return new EqualsBuilder().append(name, rhs.name).isEquals();
    }

}
