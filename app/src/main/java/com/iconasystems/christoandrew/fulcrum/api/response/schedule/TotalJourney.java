package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.Serializable;

public class TotalJourney implements Serializable
{

    @SerializedName("Duration")
    @Expose
    private String duration;
    private final static long serialVersionUID = 5694487585312425380L;

    /**
     * No args constructor for use in serialization
     *
     */
    public TotalJourney() {
    }

    /**
     *
     * @param duration
     */
    public TotalJourney(String duration) {
        super();
        this.duration = duration;
    }

    public String getDuration() {
        // format in am/pm-notation
        Period period = Period.parse(duration);
        return "Flight time: "+ period.getDays()
                +"Days "+ period.getHours()+"Hours "+period.getMinutes()+" Minutes";
    }

    public String getArrivalTime(){
        Period period = Period.parse(duration);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime arrival =  now.plus(period);
        DateTimeFormatter builder = DateTimeFormat.forPattern("MM/dd HH:mm");
        return builder.print(arrival);
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDepartureTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter builder = DateTimeFormat.forPattern("MM/dd HH:mm");
        return builder.print(now);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("duration", duration).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(duration).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TotalJourney) == false) {
            return false;
        }
        TotalJourney rhs = ((TotalJourney) other);
        return new EqualsBuilder().append(duration, rhs.duration).isEquals();
    }

}
