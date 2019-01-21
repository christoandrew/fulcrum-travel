package com.iconasystems.christoandrew.fulcrum.api.response;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {
    @SerializedName("access_token")
    private String access_token;
    @SerializedName("token_type")
    private String token_type;
    @SerializedName("expires_in")
    private int expiresIn;

    public AuthResponse() {
    }

    public String getToken() {
        return this.access_token;
    }
}
