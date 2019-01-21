package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.models.Schedule;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class ScheduleResource_ implements Serializable
{

    @SerializedName("Schedule")
    @Expose
    private List<Schedule> schedule = null;
    @SerializedName("Meta")
    @Expose
    private Meta meta;
    private final static long serialVersionUID = -2226833729108470752L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ScheduleResource_() {
    }

    /**
     *
     * @param schedule
     * @param meta
     */
    public ScheduleResource_(List<Schedule> schedule, Meta meta) {
        super();
        this.schedule = schedule;
        this.meta = meta;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("schedule", schedule).append("meta", meta).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(schedule).append(meta).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScheduleResource_) == false) {
            return false;
        }
        ScheduleResource_ rhs = ((ScheduleResource_) other);
        return new EqualsBuilder().append(schedule, rhs.schedule).append(meta, rhs.meta).isEquals();
    }

}
