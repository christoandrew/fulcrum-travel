package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Flight implements Serializable
{

    @SerializedName("Departure")
    @Expose
    private Departure departure;
    @SerializedName("Arrival")
    @Expose
    private Arrival arrival;
    @SerializedName("MarketingCarrier")
    @Expose
    private MarketingCarrier marketingCarrier;
    @SerializedName("OperatingCarrier")
    @Expose
    private OperatingCarrier operatingCarrier;
    @SerializedName("Equipment")
    @Expose
    private Equipment equipment;
    @SerializedName("Details")
    @Expose
    private Details details;
    private final static long serialVersionUID = -4610081954428328445L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Flight() {
    }

    /**
     *
     * @param operatingCarrier
     * @param marketingCarrier
     * @param details
     * @param arrival
     * @param departure
     * @param equipment
     */
    public Flight(Departure departure, Arrival arrival, MarketingCarrier marketingCarrier, OperatingCarrier operatingCarrier, Equipment equipment, Details details) {
        super();
        this.departure = departure;
        this.arrival = arrival;
        this.marketingCarrier = marketingCarrier;
        this.operatingCarrier = operatingCarrier;
        this.equipment = equipment;
        this.details = details;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public MarketingCarrier getMarketingCarrier() {
        return marketingCarrier;
    }

    public void setMarketingCarrier(MarketingCarrier marketingCarrier) {
        this.marketingCarrier = marketingCarrier;
    }

    public OperatingCarrier getOperatingCarrier() {
        return operatingCarrier;
    }

    public void setOperatingCarrier(OperatingCarrier operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("departure", departure).append("arrival", arrival).append("marketingCarrier", marketingCarrier).append("operatingCarrier", operatingCarrier).append("equipment", equipment).append("details", details).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(operatingCarrier).append(marketingCarrier).append(details).append(arrival).append(departure).append(equipment).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Flight) == false) {
            return false;
        }
        Flight rhs = ((Flight) other);
        return new EqualsBuilder().append(operatingCarrier, rhs.operatingCarrier).append(marketingCarrier, rhs.marketingCarrier).append(details, rhs.details).append(arrival, rhs.arrival).append(departure, rhs.departure).append(equipment, rhs.equipment).isEquals();
    }

}
