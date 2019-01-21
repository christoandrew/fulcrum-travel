package com.iconasystems.christoandrew.fulcrum.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iconasystems.christoandrew.fulcrum.R;
import com.iconasystems.christoandrew.fulcrum.databinding.AirportListItemBinding;
import com.iconasystems.christoandrew.fulcrum.databinding.FlightListItemBinding;
import com.iconasystems.christoandrew.fulcrum.models.Schedule;

import java.util.List;


public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    private final List<Schedule> scheduleList;

    public ScheduleAdapter(List<Schedule> schedules, OnItemClickListener onItemClickListener) {
        scheduleList = schedules;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FlightListItemBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.flight_list_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ScheduleAdapter.ViewHolder holder, int position) {
        holder.bind(scheduleList.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private FlightListItemBinding binding;
        ViewHolder(final FlightListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final Schedule schedule, final OnItemClickListener onItemClickListener) {
            binding.setSchedule(schedule);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(schedule);
                }
            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(Schedule schedule);
    }
}
