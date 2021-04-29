package com.example.smartchargecapstoneproject;

public class RoomList {
    private String RoomName, RoomDescription;

    public RoomList(){
    }

    public RoomList(String RoomName, String RoomDescription){
        this.RoomName = RoomName;
        this.RoomDescription = RoomDescription;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        this.RoomName = roomName;
    }

    public String getRoomDescription() {
        return RoomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.RoomDescription = roomDescription;
    }
}
