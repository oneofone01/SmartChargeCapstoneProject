package com.example.smartchargecapstoneproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.DeviceVH> {

    List<DeviceList> deviceListList;

    public DeviceListAdapter(List<DeviceList> deviceListList) {
        this.deviceListList = deviceListList;
    }

    @NonNull
    @Override
    public DeviceVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new DeviceVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceVH holder, int position) {

        DeviceList deviceList = deviceListList.get(position);
        holder.device_nameTxt.setText(deviceList.getDevice_name());
        holder.onlineDurationTxt.setText(deviceList.getOnlineDuration());
        holder.aveWattageConsumedTxt.setText(deviceList.getAveWattageConsumed());
        holder.currentWattageTxt.setText(deviceList.getCurrentWattage());
        holder.estDailyCostTxt.setText(deviceList.getEstDailyCost());
        holder.estMonthlyCostTxt.setText(deviceList.getEstMonthlyCost());

        boolean isExpandable = deviceListList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);


    }

    @Override
    public int getItemCount() {
        return deviceListList.size();
    }

    public class DeviceVH extends RecyclerView.ViewHolder {

        TextView device_nameTxt, onlineDurationTxt, aveWattageConsumedTxt, currentWattageTxt, estDailyCostTxt, estMonthlyCostTxt;

        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public DeviceVH(@NonNull View itemView) {
            super(itemView);

            device_nameTxt = itemView.findViewById(R.id.device_name);
            onlineDurationTxt = itemView.findViewById(R.id.onlineDuration);
            aveWattageConsumedTxt = itemView.findViewById(R.id.aveWattageConsumed);
            currentWattageTxt = itemView.findViewById(R.id.currentWattage);
            estDailyCostTxt = itemView.findViewById(R.id.estDailyCost);
            estMonthlyCostTxt = itemView.findViewById(R.id.estMonthlyCost);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandible_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DeviceList deviceList = deviceListList.get(getAdapterPosition());
                    deviceList.setExpandable(!deviceList.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
