package com.zumba.model;

public class Batch {
    private int id;
    private String batchName;
    private String startTime;
    private String endTime;
    private int maxCapacity;

    // Constructor
    public Batch(int id, String batchName, String startTime, String endTime, int maxCapacity) {
        this.id = id;
        this.batchName = batchName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxCapacity = maxCapacity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
