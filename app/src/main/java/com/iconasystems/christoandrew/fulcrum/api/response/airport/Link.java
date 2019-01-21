package com.iconasystems.christoandrew.fulcrum.api.response.airport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Link implements Serializable
{

    @SerializedName("@Href")
    @Expose
    private String href;
    @SerializedName("@Rel")
    @Expose
    private String rel;
    private final static long serialVersionUID = -5272198186687956776L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Link() {
    }

    /**
     *
     * @param rel
     * @param href
     */
    public Link(String href, String rel) {
        super();
        this.href = href;
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("href", href).append("rel", rel).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rel).append(href).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Link) == false) {
            return false;
        }
        Link rhs = ((Link) other);
        return new EqualsBuilder().append(rel, rhs.rel).append(href, rhs.href).isEquals();
    }

}
