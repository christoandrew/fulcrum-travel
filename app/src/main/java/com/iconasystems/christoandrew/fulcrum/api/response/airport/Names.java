package com.iconasystems.christoandrew.fulcrum.api.response.airport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Names implements Serializable
{

    @SerializedName("Name")
    @Expose
    private List<Name> name = null;
    private final static long serialVersionUID = -3148117315965475134L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Names() {
    }

    /**
     *
     * @param name
     */
    public Names(List<Name> name) {
        super();
        this.name = name;
    }

    public Names(String s) {
    }

    public List<Name> getName() {
        return name;
    }


    public String getAirportName(){
        String airportName  = name.get(0).getAirportCode();
        for(Name name : name){
            if(name.getLanguageCode().equals("en")){
                airportName = name.get$();
            }else {
                airportName = name.getAirportCode();
            }
        }

        return airportName;
    }

    public void setName(List<Name> name) {
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
        if ((other instanceof Names) == false) {
            return false;
        }
        Names rhs = ((Names) other);
        return new EqualsBuilder().append(name, rhs.name).isEquals();
    }

}
