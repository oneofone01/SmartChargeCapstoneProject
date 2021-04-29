package com.example.smartchargecapstoneproject;

public class ExampleRoom {
    private String mRoomName, mRoomDescription;

    public ExampleRoom(){
    }

    public ExampleRoom(String roomName, String roomDescription){
        mRoomName = roomName;
        mRoomDescription = roomDescription;

    }

    public String getRoomName() {
        return mRoomName;
    }

    public void setRoomName(String mRoomName) {
        this.mRoomName = mRoomName;
    }

    public String getRoomDescription() {
        return mRoomDescription;
    }

    public void setRoomDescription(String mRoomDescription) {
        this.mRoomDescription = mRoomDescription;
    }
}
