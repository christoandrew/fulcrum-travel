package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ScheduledTimeLocal_ implements Serializable
{

    @SerializedName("DateTime")
    @Expose
    private String dateTime;
    private final static long serialVersionUID = -2298572015106966976L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ScheduledTimeLocal_() {
    }

    /**
     *
     * @param dateTime
     */
    public ScheduledTimeLocal_(String dateTime) {
        super();
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dateTime", dateTime).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dateTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScheduledTimeLocal_) == false) {
            return false;
        }
        ScheduledTimeLocal_ rhs = ((ScheduledTimeLocal_) other);
        return new EqualsBuilder().append(dateTime, rhs.dateTime).isEquals();
    }

}
