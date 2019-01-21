package com.iconasystems.christoandrew.fulcrum.api;

import com.iconasystems.christoandrew.fulcrum.api.response.AirportResponse;
import com.iconasystems.christoandrew.fulcrum.api.response.AirportsResponse;
import com.iconasystems.christoandrew.fulcrum.api.response.AuthResponse;
import com.iconasystems.christoandrew.fulcrum.api.response.FlightScheduleResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @FormUrlEncoded
    @POST("oauth/token")
    Call<AuthResponse> login(
            @Field("client_id") String clientId,
            @Field("client_secret") String secretKey,
            @Field("grant_type") String grantType
    );

    @GET("references/airports")
    Call<AirportsResponse> getAirports();

    @GET("references/airports/{airportCode}")
    Call<AirportResponse> getAirport(@Path("airportCode") String airportCode);

    @GET("operations/schedules/{start}/{destination}/{time_of_departure}?limit=100&directFlights=0")
    Call<FlightScheduleResponse> getScheduledFlights(@Path("start") String startAirportCode,
                                                     @Path("destination") String destinationAirportCode,
                                                     @Path("time_of_departure") String timeOfDeparture);
}
