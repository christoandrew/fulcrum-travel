package com.iconasystems.christoandrew.fulcrum.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iconasystems.christoandrew.fulcrum.R;
import com.iconasystems.christoandrew.fulcrum.databinding.AirportListItemBinding;
import com.iconasystems.christoandrew.fulcrum.models.Airport;

import java.util.List;


public class AirportsAdapter extends RecyclerView.Adapter<AirportsAdapter.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private final List<Airport> airportList;

    public AirportsAdapter(List<Airport> airports, OnItemClickListener onItemClickListener) {
        airportList = airports;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AirportListItemBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.airport_list_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final AirportsAdapter.ViewHolder holder, int position) {
        holder.bind(airportList.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return airportList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private AirportListItemBinding binding;
        ViewHolder(final AirportListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final Airport airport, final OnItemClickListener onItemClickListener) {
            binding.setAirport(airport);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(airport);
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(Airport airport);
    }
}
