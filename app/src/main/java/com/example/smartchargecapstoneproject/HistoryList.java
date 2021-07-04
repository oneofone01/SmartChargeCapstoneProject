package com.example.smartchargecapstoneproject;

public class HistoryList {

    private String history_description, history_action;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public HistoryList(String history_description, String history_action){
        this.history_description = history_description;
        this.history_action = history_action;
        this.expandable = false;
    }

    public String getHistory_description() {
        return history_description;
    }

    public void setHistory_description(String history_description) {
        this.history_description = history_description;
    }

    public String getHistory_action() {
        return history_action;
    }

    public void setHistory_action( String history_action) {
        this.history_action = history_action;
    }

    @Override
    public String toString() {
        return "HistoryList{" +
                "historyDescription ='" + history_description + '\'' +
                ", historyAction ='" + history_action + '\'' +
                '}';
    }
}
