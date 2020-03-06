
package com.example.cambiomodena.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conversion {

    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("rate")
    @Expose
    private Double rate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Conversion() {
    }

    /**
     * 
     * @param date
     * @param rate
     * @param to
     */
    public Conversion(String to, String date, Double rate) {
        super();
        this.to = to;
        this.date = date;
        this.rate = rate;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}
