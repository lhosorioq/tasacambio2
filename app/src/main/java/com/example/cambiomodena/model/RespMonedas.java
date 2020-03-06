
package com.example.cambiomodena.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RespMonedas {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RespMonedas() {
    }

    /**
     * 
     * @param result
     * @param status
     */
    public RespMonedas(Result result, String status) {
        super();
        this.result = result;
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
