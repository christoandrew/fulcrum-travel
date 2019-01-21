package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Details implements Serializable
{

    @SerializedName("Stops")
    @Expose
    private Stops stops;
    @SerializedName("DaysOfOperation")
    @Expose
    private long daysOfOperation;
    @SerializedName("DatePeriod")
    @Expose
    private DatePeriod datePeriod;
    private final static long serialVersionUID = 485819973554781516L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Details() {
    }

    /**
     *
     * @param stops
     * @param daysOfOperation
     * @param datePeriod
     */
    public Details(Stops stops, long daysOfOperation, DatePeriod datePeriod) {
        super();
        this.stops = stops;
        this.daysOfOperation = daysOfOperation;
        this.datePeriod = datePeriod;
    }

    public Stops getStops() {
        return stops;
    }

    public void setStops(Stops stops) {
        this.stops = stops;
    }

    public long getDaysOfOperation() {
        return daysOfOperation;
    }

    public void setDaysOfOperation(long daysOfOperation) {
        this.daysOfOperation = daysOfOperation;
    }

    public DatePeriod getDatePeriod() {
        return datePeriod;
    }

    public void setDatePeriod(DatePeriod datePeriod) {
        this.datePeriod = datePeriod;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("stops", stops).append("daysOfOperation", daysOfOperation).append("datePeriod", datePeriod).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(stops).append(daysOfOperation).append(datePeriod).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Details) == false) {
            return false;
        }
        Details rhs = ((Details) other);
        return new EqualsBuilder().append(stops, rhs.stops).append(daysOfOperation, rhs.daysOfOperation).append(datePeriod, rhs.datePeriod).isEquals();
    }

}
