package com.iconasystems.christoandrew.fulcrum.api.response.schedule;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Meta implements Serializable
{

    @SerializedName("@Version")
    @Expose
    private String version;
    @SerializedName("Link")
    @Expose
    private List<Link> link = null;
    private final static long serialVersionUID = 2428100838409815125L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Meta() {
    }

    /**
     *
     * @param link
     * @param version
     */
    public Meta(String version, List<Link> link) {
        super();
        this.version = version;
        this.link = link;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("version", version).append("link", link).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(link).append(version).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Meta) == false) {
            return false;
        }
        Meta rhs = ((Meta) other);
        return new EqualsBuilder().append(link, rhs.link).append(version, rhs.version).isEquals();
    }

}
