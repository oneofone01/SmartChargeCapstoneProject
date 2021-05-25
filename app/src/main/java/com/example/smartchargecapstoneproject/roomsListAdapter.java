package com.example.smartchargecapstoneproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class roomsListAdapter extends RecyclerView.Adapter<roomsListAdapter.ExampleViewHolder>{

    Context context;
    ArrayList<RoomList> list;

    //private ArrayList<ExampleRoom> mExampleRooms;

    public roomsListAdapter(Context context, ArrayList<RoomList> list) {
        this.context = context;
        this.list = list;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView RoomName;
        public TextView RoomDescription;
        View mView;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            RoomName = itemView.findViewById(R.id.text_view_name);
            RoomDescription = itemView.findViewById(R.id.text_description_name);
            mView=itemView;
        }
    }

    /*public roomsListAdapter(ArrayList<ExampleRoom> exampleRooms){
        mExampleRooms = exampleRooms;
    }*/

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_rooms, parent, false);
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_view_rooms, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        //ExampleRoom room = mExampleRooms.get(position);
        RoomList roomList = list.get(position);
        holder.RoomName.setText(roomList.getRoomName());
        holder.RoomDescription.setText(roomList.getRoomDescription());


        /*holder.mRoomName.setText(room.getRoomName());
        holder.mRoomDescription.setText(room.getRoomDescription());*/
    }

    @Override
    public int getItemCount() {
        //return mExampleRooms.size();
        return list.size();
    }

    public void setItems(  ArrayList<RoomList> list) {
        this.list = new ArrayList<RoomList>(list);
    }
}



/*public class roomsListAdapter extends RecyclerView.Adapter<roomsListAdapter.roomVH>{
    List<RoomList> roomListList;

    public roomsListAdapter(List<RoomList> roomListList){
        this.roomListList = roomListList;
    }

    @NonNull
    @Override
    public roomsListAdapter.roomVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull roomsListAdapter.roomVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class roomVH extends RecyclerView.ViewHolder {
        TextView edit_roomName, edit_roomDescription;
        public roomVH(@NonNull View itemView){
            super(itemView);
            edit_roomName = itemView.findViewById(R.id.edit_roomName);
            edit_roomDescription = itemView.findViewById(R.id.edit_roomDescription);
        }
    }
}*/
