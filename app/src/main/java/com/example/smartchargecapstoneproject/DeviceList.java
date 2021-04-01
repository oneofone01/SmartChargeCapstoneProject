package com.example.smartchargecapstoneproject;

public class DeviceList {
    private String device_name, onlineDuration, aveWattageConsumed, currentWattage, estDailyCost, estMonthlyCost;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public DeviceList(String device_name, String onlineDuration, String aveWattageConsumed, String currentWattage, String estDailyCost, String estMonthlyCost) {
        this.device_name = device_name;
        this.onlineDuration = onlineDuration;
        this.aveWattageConsumed = aveWattageConsumed;
        this.currentWattage = currentWattage;
        this.estDailyCost = estDailyCost;
        this.estMonthlyCost = estMonthlyCost;
        this.expandable = false;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getOnlineDuration() {
        return onlineDuration;
    }

    public void setOnlineDuration(String onlineDuration) {
        this.onlineDuration = onlineDuration;
    }

    public String getAveWattageConsumed() {
        return aveWattageConsumed;
    }

    public void setAveWattageConsumed(String aveWattageConsumed) {
        this.aveWattageConsumed = aveWattageConsumed;
    }

    public String getCurrentWattage() {
        return currentWattage;
    }

    public void setCurrentWattage(String currentWattage) {
        this.currentWattage = currentWattage;
    }

    public String getEstDailyCost() {
        return estDailyCost;
    }

    public void setEstDailyCost(String estDailyCost) {
        this.estDailyCost = estDailyCost;
    }

    public String getEstMonthlyCost() {
        return estMonthlyCost;
    }

    public void setEstMonthlyCost(String estMonthlyCost) {
        this.estMonthlyCost = estMonthlyCost;
    }

    @Override
    public String toString() {
        return "DeviceList{" +
                "device_name='" + device_name + '\'' +
                ", onlineDuration='" + onlineDuration + '\'' +
                ", aveWattageConsumed='" + aveWattageConsumed + '\'' +
                ", currentWattage='" + currentWattage + '\'' +
                ", estDailyCost='" + estDailyCost + '\'' +
                ", estMonthlyCost='" + estMonthlyCost + '\'' +
                '}';
    }


}
