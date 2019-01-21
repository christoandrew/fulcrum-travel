package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class DatePeriod implements Serializable
{

    @SerializedName("Effective")
    @Expose
    private String effective;
    @SerializedName("Expiration")
    @Expose
    private String expiration;
    private final static long serialVersionUID = 3765984180982473640L;

    /**
     * No args constructor for use in serialization
     *
     */
    public DatePeriod() {
    }

    /**
     *
     * @param expiration
     * @param effective
     */
    public DatePeriod(String effective, String expiration) {
        super();
        this.effective = effective;
        this.expiration = expiration;
    }

    public String getEffective() {
        return effective;
    }

    public void setEffective(String effective) {
        this.effective = effective;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("effective", effective).append("expiration", expiration).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(expiration).append(effective).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DatePeriod) == false) {
            return false;
        }
        DatePeriod rhs = ((DatePeriod) other);
        return new EqualsBuilder().append(expiration, rhs.expiration).append(effective, rhs.effective).isEquals();
    }

}


