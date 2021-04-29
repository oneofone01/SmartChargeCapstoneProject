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

public class MyRoomsHomeCardAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<MyRoomsHomeCardModel> modelArrayList;

    //constructor
    public MyRoomsHomeCardAdapter(Context context, ArrayList<MyRoomsHomeCardModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
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
        View view = LayoutInflater.from(context).inflate(R.layout.home_rooms_cards, container, false);

        //init uid views from _home_rooms_cards.xml
        TextView roomHomeCardName = view.findViewById(R.id.roomHomeCardName);

        //get data
        MyRoomsHomeCardModel model = modelArrayList.get(position);
        String roomName = model.getRoomName();

        //set data
        roomHomeCardName.setText(roomName);

        //handle card click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, roomName + "\n" + description, Toast.LENGTH_SHORT).show();
                Toast.makeText(context, roomName, Toast.LENGTH_SHORT).show();
            }
        });

        //add view to container
        container.addView(view, position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
