package com.iconasystems.christoandrew.fulcrum.api.response.airport;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iconasystems.christoandrew.fulcrum.models.Airport;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@Entity(tableName = "names",foreignKeys = @ForeignKey(entity = Airport.class,
        parentColumns = "airportCode",
        childColumns = "airportCode"))
public class Name implements Serializable
{
    private String airportCode;
    @SerializedName("@LanguageCode")
    @Expose
    private String languageCode;
    @NonNull
    @PrimaryKey
    @SerializedName("$")
    @Expose
    private String $;
    private final static long serialVersionUID = 8716098795641710064L;

    /**
     * No args constructor for use in serialization
     *
     * @param elem
     */
    public Name() {
    }

    /**
     *
     * @param languageCode
     * @param $
     */
    public Name(String languageCode, String $) {
        super();
        this.languageCode = languageCode;
        this.$ = $;
    }

    public Name(String languageCode, String $, String airportCode) {
        super();
        this.languageCode = languageCode;
        this.$ = $;
        this.airportCode = airportCode;
    }

    public Name(String s) {
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String get$() {
        return $;
    }

    public void set$(String $) {
        this.$ = $;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("languageCode", languageCode).append("$", $).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(languageCode).append($).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Name) == false) {
            return false;
        }
        Name rhs = ((Name) other);
        return new EqualsBuilder().append(languageCode, rhs.languageCode).append($, rhs.$).isEquals();
    }

}
