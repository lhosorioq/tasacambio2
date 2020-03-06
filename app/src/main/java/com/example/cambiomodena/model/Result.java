
package com.example.cambiomodena.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("conversion")
    @Expose
    private List<Conversion> conversion = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param from
     * @param conversion
     */
    public Result(String from, List<Conversion> conversion) {
        super();
        this.from = from;
        this.conversion = conversion;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<Conversion> getConversion() {
        return conversion;
    }

    public void setConversion(List<Conversion> conversion) {
        this.conversion = conversion;
    }

}
