package com.inhatc.anywhere;

public class SampleData {
    private String busNumber;
    private String busType;

    public SampleData(String busNumber, String busType){
        this.busNumber = busNumber;
        this.busType = busType;
    }


    public String getBusNumber()
    {
        return this.busNumber;
    }

    public String getBusType()
    {
        return this.busType;
    }

}
