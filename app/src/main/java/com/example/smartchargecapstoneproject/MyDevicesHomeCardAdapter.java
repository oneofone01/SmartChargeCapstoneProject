package com.example.smartchargecapstoneproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;

public class MyDevicesHomeCardAdapter extends PagerAdapter {
    private Context context;
    //private List<DeviceList> modelArrayList;
    private List<MyDevicesHomeCardModel> modelArrayList;

    //constructor
    public MyDevicesHomeCardAdapter(Context context, List<MyDevicesHomeCardModel> model) {
        this.context = context;
        this.modelArrayList = model;
    }

    @Override
    public int getCount() {
        return modelArrayList.size(); //returns size of items in list
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //inflate layout home_rooms_cards.xml
        //layoutInflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(context).inflate(R.layout.home_devices_cards, container, false);

        //init uid views from _home_rooms_cards.xml
        TextView deviceHomeCardName = view.findViewById(R.id.deviceHomeCardName);

        //get data
        MyDevicesHomeCardModel model = modelArrayList.get(position);
        String deviceName = model.getDeviceName();

        //set data
        deviceHomeCardName.setText(deviceName);

        //handle card click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, roomName + "\n" + description, Toast.LENGTH_SHORT).show();
                Toast.makeText(context, deviceName, Toast.LENGTH_SHORT).show();
            }
        });

        //add view to container
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public float getPageWidth(int position) {
        return(0.5f);
    }

    public void setArrayItems(ArrayList<MyDevicesHomeCardModel> modelArrayList) {
        this.modelArrayList = new ArrayList<>(modelArrayList);
    }
}

/*public class MyDevicesHomeCardAdapter extends PagerAdapter {
    private Context context;

    //private ArrayList<MyDevicesHomeCardModel> modelArrayList2;
    private List<DeviceList> deviceListList;


    //constructor
    public MyDevicesHomeCardAdapter(Context context, List<DeviceList> deviceListList) {
        this.context = context;
        this.deviceListList = deviceListList;
    }

    @Override
    public int getCount() {
        return deviceListList.size(); //returns size of items in list
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //inflate layout home_rooms_cards.xml
        View view = LayoutInflater.from(context).inflate(R.layout.home_devices_cards, container, false);

        //init uid views from _home_rooms_cards.xml
        TextView deviceHomeCardName = view.findViewById(R.id.deviceHomeCardName);

        //get data
        MyDevicesHomeCardModel model = deviceListList.get(position);
        String deviceName = model.getDeviceName();

        //set data
        deviceHomeCardName.setText(deviceName);

        //handle card click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, roomName + "\n" + description, Toast.LENGTH_SHORT).show();
                Toast.makeText(context, deviceName, Toast.LENGTH_SHORT).show();
            }
        });

        //add view to container
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    public void setArrayItems(List<MyDevicesHomeCardModel> modelArrayList) {
        this.modelArrayList = new List<>(modelArrayList);
    }
}*/
