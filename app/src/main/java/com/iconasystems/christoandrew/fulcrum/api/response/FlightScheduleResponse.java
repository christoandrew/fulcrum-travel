package com.iconasystems.christoandrew.fulcrum.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.api.response.schedule.ScheduleResource_;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class FlightScheduleResponse implements Serializable {

    @SerializedName("ScheduleResource")
    @Expose
    private ScheduleResource_ scheduleResource;
    private final static long serialVersionUID = 2360133799682152775L;

    /**
     * No args constructor for use in serialization
     *
     */
    public FlightScheduleResponse() {
    }

    /**
     *
     * @param scheduleResource
     */
    public FlightScheduleResponse(ScheduleResource_ scheduleResource) {
        super();
        this.scheduleResource = scheduleResource;
    }

    public ScheduleResource_ getScheduleResource() {
        return scheduleResource;
    }

    public void setScheduleResource(ScheduleResource_ scheduleResource) {
        this.scheduleResource = scheduleResource;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("scheduleResource", scheduleResource).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(scheduleResource).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FlightScheduleResponse) == false) {
            return false;
        }
        FlightScheduleResponse rhs = ((FlightScheduleResponse) other);
        return new EqualsBuilder().append(scheduleResource, rhs.scheduleResource).isEquals();
    }

}
