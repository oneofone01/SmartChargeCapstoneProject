package com.example.smartchargecapstoneproject.data;

import com.example.smartchargecapstoneproject.DeviceList;
import com.example.smartchargecapstoneproject.MyDevicesHomeCardModel;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    static List<DeviceList> deviceListList = new ArrayList<>();
    static List<MyDevicesHomeCardModel> deviceHomeCardList = new ArrayList<>();
    static DataProvider INSTANCE = new DataProvider();

    private DataProvider(){
        deviceListList.add(new DeviceList(" Bathroom Outlet", "Online For: 15 Hours", "Average Wattage Consumed: 1115 W/Hr", "Current Wattage Usage: ~115 Watts", "Estimated Daily Energy Cost: $5.50", "Estimated Monthly Energy Cost: $52.14"));
        deviceListList.add(new DeviceList(" Garage Outlet", "Online For: 22 Hours", "Average Wattage Consumed: 2134 W/Hr", "Current Wattage Usage: ~300 Watts", "Estimated Daily Energy Cost: $5.51", "Estimated Monthly Energy Cost: $52.65"));
        deviceListList.add(new DeviceList(" Kitchen Outlet", "Online For: 17 Hours", "Average Wattage Consumed: 1700 W/Hr", "Current Wattage Usage: ~174 Watts", "Estimated Daily Energy Cost: $4.75", "Estimated Monthly Energy Cost: $50.87"));
        deviceListList.add(new DeviceList(" Bedroom Outlet", "Online For: 35 Hours", "Average Wattage Consumed: 2500 W/Hr", "Current Wattage Usage: ~621 Watts", "Estimated Daily Energy Cost: $8.21", "Estimated Monthly Energy Cost: $100.10"));
        deviceListList.add(new DeviceList(" Office Outlet", "Online For: 12 Hours", "Average Wattage Consumed: 1250 W/Hr", "Current Wattage Usage: ~250 Watts", "Estimated Daily Energy Cost: $3.50", "Estimated Monthly Energy Cost: $35.27"));
        deviceListList.add(new DeviceList(" Pool House Outlet", "Online For: 5 Hours", "Average Wattage Consumed: 155 W/Hr", "Current Wattage Usage: ~96 Watts", "Estimated Daily Energy Cost: $2.90", "Estimated Monthly Energy Cost: $22.00"));
        deviceListList.add(new DeviceList(" Game Room Outlet", "Online For: 19 Hours", "Average Wattage Consumed: 1520 W/Hr", "Current Wattage Usage: ~326 Watts", "Estimated Daily Energy Cost: $5.11", "Estimated Monthly Energy Cost: $45.52"));

    }

    public static List<DeviceList> getDeviceList(){
       return deviceListList;
    }

    public static List<MyDevicesHomeCardModel> getDeviceHomeCardList(){
        //for (int i = 0; i < 10; i++) {
            //deviceHomeCardList.add(new MyDevicesHomeCardModel("ABC "+i));
        deviceHomeCardList.add(new MyDevicesHomeCardModel("Bathroom Outlet"));
        deviceHomeCardList.add(new MyDevicesHomeCardModel("Garage Outlet"));
        deviceHomeCardList.add(new MyDevicesHomeCardModel("Kitchen Outlet"));
        deviceHomeCardList.add(new MyDevicesHomeCardModel("Bedroom Outlet"));
        deviceHomeCardList.add(new MyDevicesHomeCardModel("Office Outlet"));
        deviceHomeCardList.add(new MyDevicesHomeCardModel("Pool House Outlet"));
        deviceHomeCardList.add(new MyDevicesHomeCardModel("Game Room Outlet"));

        return deviceHomeCardList;
    }
}
