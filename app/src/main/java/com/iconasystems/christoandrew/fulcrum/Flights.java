package com.iconasystems.christoandrew.fulcrum;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iconasystems.christoandrew.fulcrum.api.ApiClient;
import com.iconasystems.christoandrew.fulcrum.api.ApiService;
import com.iconasystems.christoandrew.fulcrum.api.response.AirportResponse;
import com.iconasystems.christoandrew.fulcrum.api.response.AirportsResponse;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Coordinate;
import com.iconasystems.christoandrew.fulcrum.api.response.schedule.Flight;
import com.iconasystems.christoandrew.fulcrum.models.Airport;
import com.iconasystems.christoandrew.fulcrum.network.AuthInterceptor;
import com.iconasystems.christoandrew.fulcrum.viewmodel.AirportsViewModel;
import com.iconasystems.christoandrew.fulcrum.viewmodel.TokenViewModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Flights extends FragmentActivity implements OnMapReadyCallback {
    private static final String TAG = Flights.class.getSimpleName();
    private TokenViewModel tokenViewModel;
    private AirportsViewModel airportsViewModel;
    private GoogleMap mMap;
    private List<LatLng> route;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        airportsViewModel = ViewModelProviders.of(this).get(AirportsViewModel.class);
        tokenViewModel = ViewModelProviders.of(this).get(TokenViewModel.class);

        Intent intent = getIntent();
        List<Flight> flightList = new Gson().fromJson(intent.getStringExtra("flights"),
                new TypeToken<List<Flight>>() {
                }.getType());

        route = getRoute(flightList);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng startPoint = route.get(0);
        LatLng endPoint = route.get(route.size()-1);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : route) {
            builder.include(latLng);
        }

        LatLngBounds bounds = builder.build();

        PolylineOptions options = new PolylineOptions();
        options.color(Color.BLUE)
                .width(5)
                .visible(true)
                .zIndex(30);
        options.addAll(route);
        // Add a marker in Sydney and move the camera
        googleMap.addPolyline(options);

        final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 5);
        googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                googleMap.animateCamera(cu);
            }
        });

        googleMap.addMarker(new MarkerOptions().position(startPoint)
                .title("Origin"));

        googleMap.addMarker(new MarkerOptions().position(endPoint)
                .title("Destination"));

    }

    private List<LatLng> getRoute(List<Flight> flights) {
        List<LatLng> route = new ArrayList<>();
        for (Flight flight : flights) {
            String arrivalAirportCode = flight.getArrival().getAirportCode();
            String departureAirportCode = flight.getDeparture().getAirportCode();
            final Airport[] arrivalAirport = {airportsViewModel.getAirport(arrivalAirportCode)};
            final Airport[] departureAirport = {airportsViewModel.getAirport(departureAirportCode)};


            Coordinate arrivalCoordinate = null;
            Coordinate departureCoordinate = null;

            if (departureAirport[0] == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                AuthInterceptor authInterceptor = new AuthInterceptor(tokenViewModel.getToken().getToken());
                ApiClient client = new ApiClient();
                client.addInterceptor(authInterceptor);
                ApiService apiService = client.getClient(builder).create(ApiService.class);

                Call<AirportResponse> airportListCall = apiService.getAirport(departureAirportCode);

                airportListCall.enqueue(new Callback<AirportResponse>() {
                    @Override
                    public void onResponse(Call<AirportResponse> call, Response<AirportResponse> response) {
                        if (response.body() != null) {
                            airportsViewModel.insertAirport(response.body()
                                    .getSingleAirportResource()
                                    .getAirports()
                                    .getAirport());

                            departureAirport[0] = airportsViewModel.getAirport(departureAirportCode);
                        }

                    }

                    @Override
                    public void onFailure(Call<AirportResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

                if (airportListCall.isExecuted()) {
                    if (departureAirport[0] != null) {
                        departureAirport[0] = airportsViewModel.getAirport(departureAirportCode);
                        departureCoordinate = departureAirport[0].getPosition().getCoordinate();
                        route.add(new LatLng(departureCoordinate.getLatitude(), departureCoordinate.getLongitude()));
                    }
                }
            } else {
                departureCoordinate = departureAirport[0].getPosition().getCoordinate();
                route.add(new LatLng(departureCoordinate.getLatitude(), departureCoordinate.getLongitude()));
            }


            if (arrivalAirport[0] == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                AuthInterceptor authInterceptor = new AuthInterceptor(tokenViewModel.getToken().getToken());
                ApiClient client = new ApiClient();
                client.addInterceptor(authInterceptor);
                ApiService apiService = client.getClient(builder).create(ApiService.class);

                Call<AirportResponse> airportListCall = apiService.getAirport(arrivalAirportCode);

                airportListCall.enqueue(new Callback<AirportResponse>() {
                    @Override
                    public void onResponse(Call<AirportResponse> call, Response<AirportResponse> response) {
                        if (response.body() != null) {
                            airportsViewModel.insertAirport(response.body()
                                    .getSingleAirportResource()
                                    .getAirports()
                                    .getAirport());

                            arrivalAirport[0] = airportsViewModel.getAirport(arrivalAirportCode);
                        }

                    }

                    @Override
                    public void onFailure(Call<AirportResponse> call, Throwable t) {
                        t.printStackTrace();

                    }
                });

                if (airportListCall.isExecuted()) {
                    if (arrivalAirport[0] != null)
                        arrivalCoordinate = arrivalAirport[0].getPosition().getCoordinate();
                    if (arrivalCoordinate != null) {
                        route.add(new LatLng(arrivalCoordinate.getLatitude(), arrivalCoordinate.getLongitude()));
                    }

                }

            } else {
                arrivalCoordinate = arrivalAirport[0].getPosition().getCoordinate();
                route.add(new LatLng(arrivalCoordinate.getLatitude(), arrivalCoordinate.getLongitude()));
            }
        }

        return removeDuplicates(route);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
