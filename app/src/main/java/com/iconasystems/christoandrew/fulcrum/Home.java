package com.iconasystems.christoandrew.fulcrum;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.iconasystems.christoandrew.fulcrum.api.response.airport.Name;
import com.iconasystems.christoandrew.fulcrum.models.Airport;
import com.iconasystems.christoandrew.fulcrum.viewmodel.AirportsViewModel;
import com.iconasystems.christoandrew.fulcrum.viewmodel.TokenViewModel;

public class Home extends AppCompatActivity {
    private Button mSelectOriginButton;
    private Button mSelectDestinationButton;
    private Button mFindFlightsButton;
    private static final String TAG = Home.class.getSimpleName();
    private static final int SELECT_ORIGIN_RESULT = 101;
    private static final int SELECT_DESTINATION_RESULT = 102;
    private Airport origin;
    private Airport destination;
    private TextView mFlightOrigin;
    private TextView mFlightDestination;
    private AirportsViewModel airportsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TokenViewModel tokenViewModel = ViewModelProviders.of(this).get(TokenViewModel.class);
        airportsViewModel = ViewModelProviders.of(this).get(AirportsViewModel.class);
        mSelectOriginButton = findViewById(R.id.select_origin);
        mSelectDestinationButton = findViewById(R.id.select_destination);
        mFindFlightsButton = findViewById(R.id.find_flights);

        mFlightOrigin = findViewById(R.id.flight_origin);
        mFlightDestination = findViewById(R.id.flight_destination);

        mSelectOriginButton.setOnClickListener(v -> startActivityForResult(
                new Intent(getApplicationContext(), SelectAirport.class),
                SELECT_ORIGIN_RESULT)
        );

        mSelectDestinationButton.setOnClickListener(v -> startActivityForResult(
                new Intent(getApplicationContext(), SelectAirport.class),
                SELECT_DESTINATION_RESULT)
        );

        mFindFlightsButton.setOnClickListener(v -> {
            if (this.origin == null) {
                Toast.makeText(this, "Select an origin", Toast.LENGTH_LONG).show();
            } else if (this.destination == null) {
                Toast.makeText(this, "Select a destination", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), FlightSchedules.class);
                intent.putExtra("origin", this.origin.getAirportCode());
                intent.putExtra("destination", this.destination.getAirportCode());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == SELECT_ORIGIN_RESULT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {


                this.origin = new Gson().fromJson(data.getStringExtra("airport"),
                        Airport.class);
                this.mFlightOrigin.setText(this.origin.getAirportCode());
            }
        }

        if (requestCode == SELECT_DESTINATION_RESULT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String airportName = null;
                this.destination = new Gson().fromJson(data.getStringExtra("airport"),
                        Airport.class);

                this.mFlightDestination.setText(this.destination.getAirportCode());
            }
        }
    }
}
